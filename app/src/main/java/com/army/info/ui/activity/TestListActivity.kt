package com.army.info.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.army.info.R
import com.army.info.data.TestModel
import com.army.info.databinding.ActivityTestBinding
import com.army.info.databinding.ActivityTestListBinding
import com.army.info.ui.adapter.TestModelAdapter

class TestListActivity : AppCompatActivity() {
    private val binding: ActivityTestListBinding by lazy {
        ActivityTestListBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val _category = intent.getIntExtra("category", 1)

        // TODO :: 아래에 TestModel 하나가 문제 하나
        // category : 과 번호 (1이면 1과)
        // subCategory : 소제목
        // index : 소제목 내 문제 번호
        // question : 문제 본문
        // answer : 정답 본문
        // listOf() 내에 문제 추가하면 됩니다.

        val testModels = listOf(
            TestModel(
                1,
                "1-1 국가란 무엇인가?",
                1,
                "국가의 정의란?",
                "일정한 영토와 그 영토에 거주하는 사람들로 구성, 주권에 의한 하나의 통치조직을 가지고 있는 사회집단"
            ),
            TestModel(
                1, "1-1 국가란 무엇인가?", 2, "국가의 구성요소", "영토: 국민의 생활공간, 주권이나 통치권이 미치는 영역\n" +
                        "국민: 국가 구성원이 되는 법적 자격을 가진 모든 사람\n" +
                        "주권: 국가의 의사를 최종적으로 결정하는 최고 권력\n"
            ),
            TestModel(
                1,
                "1-1 국가란 무엇인가?",
                3,
                "국가의 기능과 역할",
                "1차적 기능: 적의 침략으로부터 국민, 영토, 주권 보호의 국방기능과 국민의 생명과 재산을 보호하고 유지하는 치안유지 기능\n" +
                        "2차적 기능: 경제, 사회, 문화 등 다양한 분야에서 공공복지 사업을 통한 국민 개개인의 삶의 질 향상\n" +
                        "소극적 국가관: 국가는 치안, 사유재산보호 등 최소한의 역할 수행\n" +
                        "적극적 국가관: 국가는 사회보장 제도, 독과점 규제, 환경보전 등의 정책실시와 같이 국민 생활에 적극 개입, 오늘날 대부분 국가는 국민의 공공복리와 행복 증진에 주안점을 둔 복지국가 지향\n"
            ),

            // 5과
            TestModel(
                5,
                "5-1 국가안보와 적",
                1,
                "국가안보와 적의 정의에 대해 설명할 수 있는가?",
                "국가안보의 정의: 국내외 군사,비군사적 위협으로부터 정치, 경제, 외교, 사회, 군사 등의 수단을 운용하여 국가이익을 지키는 것. 국가이익이란 국가보전, 번영과 발전, 국위선양 등 국가가 반드시 지켜야 할 핵심가치임. 적이란 국가의 존립, 안전보장, 자주권 행사, 번영과 발전 등 국가이익에 심대한 위협이 되는 대상 또는 이를 지원, 동조하는 세력. "
            ),

            // 8과
            TestModel(
                8,
                "8-1 나라가 있어야 국민이 있다",
                1,
                "나라를 잃으면 모든 것을 잃게 되므로 국방이 흔들리면 안되는 이유를 예를 들어 설명할 수 있는가?",
                "일제강점기가 말해 주듯 주권이 강탈 당함으로서 노예적인 삶과 험란한 고통이 국민들의 최소한 인간적 존엄도 지킬 수 없음. 영토, 국가 없이 민족 정체성만 있던 유대인을 히틀러가 600만명 학살, 외침으로 나라를 잃은 경우 나라가 있어야 국민이 있다는 교훈. 외부 군사위협에서 국민의 생명과 재산을 지키고 삶의 터전을 확보하는게 국방, 국방은 국가정책의 최우선 정책, 국방이 흔들리면 나라를 잃음."
            ),

            // 11과
        )

        val adapter = TestModelAdapter(testModels.filter { it.category == _category})
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }


}