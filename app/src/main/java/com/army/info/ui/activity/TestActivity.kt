package com.army.info.ui.activity

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.army.info.data.TestModel
import com.army.info.databinding.ActivityTestBinding
import kotlinx.coroutines.Job


class TestActivity : AppCompatActivity(), RecognitionListener {

    private val binding: ActivityTestBinding by lazy {
        ActivityTestBinding.inflate(layoutInflater)
    }
    private val requestPermission =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            if (!it) {
                Toast.makeText(
                    this,
                    "권한이 없으면 해당 서비스를 사용하실 수 없습니다.",
                    Toast.LENGTH_SHORT
                ).show()

                finish()
            }
        }

    private val speechRecognizer by lazy { SpeechRecognizer.createSpeechRecognizer(this) }
    private var speechRecognizerIntent: Intent? = null

    private var job: Job? = null

    private var testModel: TestModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.RECORD_AUDIO
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermission.launch(Manifest.permission.RECORD_AUDIO)
        }

        // 문제 설정
        testModel = intent.getSerializableExtra("data") as TestModel
        binding.tvQuestion.text = testModel?.question

        binding.btnSubmit.setOnClickListener {

            // TODO :: 이 if문 주석처리 하면 정답 체크 기능 제거
            var testres = if (testModel?.answer.toString() == binding.etWord.text.toString()) {
                "정답입니다."
            } else {
                "오답입니다."
            }

            // TODO :: 아래는 정답체크 없는 기능
            //testres = "정답 보기"

            AlertDialog.Builder(this@TestActivity)
                .setTitle("$testres")
                .setMessage(testModel?.answer.toString())
                .setPositiveButton("확인") { dialog, which ->

                }
                .create()
                .show()
        }

        binding.btnStt.setOnClickListener {
            val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
            intent.putExtra(
                RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
            )
            startActivityForResult(intent, 121)
        }
    }

    private fun stopSpeechRecognizer() {
        if (speechRecognizerIntent == null) return

        speechRecognizer.stopListening()
        speechRecognizerIntent = null
        job?.cancel()
    }

    override fun onReadyForSpeech(p0: Bundle?) {
    }

    override fun onBeginningOfSpeech() {
    }

    override fun onRmsChanged(p0: Float) {
    }

    override fun onBufferReceived(p0: ByteArray?) {
    }

    override fun onEndOfSpeech() {
        stopSpeechRecognizer()
    }

    override fun onError(p0: Int) {
        val message: String = when (p0) {
            SpeechRecognizer.ERROR_AUDIO -> "오디오 에러"
            SpeechRecognizer.ERROR_CLIENT -> "클라이언트 에러"
            SpeechRecognizer.ERROR_INSUFFICIENT_PERMISSIONS -> "퍼미션 없음"
            SpeechRecognizer.ERROR_NETWORK -> "네트워크 에러"
            SpeechRecognizer.ERROR_NETWORK_TIMEOUT -> "네트웍 타임아웃"
            SpeechRecognizer.ERROR_NO_MATCH -> "찾을 수 없음"
            SpeechRecognizer.ERROR_RECOGNIZER_BUSY -> "RECOGNIZER가 바쁨"
            SpeechRecognizer.ERROR_SERVER -> "서버 이상"
            SpeechRecognizer.ERROR_SPEECH_TIMEOUT -> "시간초과"
            else -> "알 수 없는 오류"
        }

        Log.e("MainActivity", "onError: $message")
    }

    override fun onResults(p0: Bundle?) {
    }

    override fun onPartialResults(p0: Bundle?) {
    }

    override fun onEvent(p0: Int, p1: Bundle?) {
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 121 && resultCode == RESULT_OK) {

            val matches_text = data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
            binding.etWord.setText(matches_text?.get(0).toString())
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

}