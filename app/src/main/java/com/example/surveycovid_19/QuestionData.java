package com.example.surveycovid_19;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class QuestionData {
    public String[] Questions={
            "Saya pergi keluar rumah",
            "Saya menggunakan transportasi umum: online, angkot, bus, taksi, kereta api",
            "Saya tidak memakai masker pada saat berkumpul dengan orang lain",
            "Saya berjabat tangan dengan orang lain",
            "Saya tidak membersihkan tangan dengan hand sanitizer / tissue basah sebelum pegan kemudi mobil/motor",
            "Saya menyentuh benda / uang yang juga disentuh orang lain",
            "Saya tidak menjaga jarak 1,5 meter dengan orang lain ketika : belanja, bekerja, belajar, ibadah",
            "Saya makan diluar rumah(warung/restaurant)",
            "Saya tidak minum hangat dan cuci tangan dengan sabun setelah tiba di tujuan",
            "Saya berada di wilayah kelurahan tempat pasien tertular",
            "Saya tidak pasang hand sanitizer di depan pintu masuk, untuk bersihkan tangan sebelum pegang gagang(handle) pintu masuk rumah",
            "Saya tidak mencuci tangan dengan sabun setelah tiba di rumah",
            "Saya tidak menyediakan tissue basah/antiseptic, masker, sabun antiseptic bagi keluarga di rumah.",
            "Saya tidak segera merendam baju dan celana bekas pakai di luar rumah kedalam air panas/sabun",
            "Saya tidak segera mandi keramas setelah saya tiba di rumah.",
            "Saya tidak mensosiailsasikan check list penilaian resiko pribadi ini kepada keluarga di rumah",
            "Saya dalam sehari tidak kena cahaya matahari minimal 15 menit",
            "Saya tidak jalan kaki/berolah raga minimal 30 menit setiap hari",
            "Saya jarang minum vitamin C dan E, dan kurang tidur",
            "Usia saya diatas 60 tahun",
            "Saya mempunyai penyakit : jantung/diabetes/gangguan pernafasan kronik"
    };
    public boolean[] Answers = {
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false
    };
//    static ArrayList<Question> getListData(){
//        ArrayList<Question> list = new ArrayList<>();
//        for(int position = 0; position< Questions.length; position++){
//            Question question = new Question();
//            question.setQuestion(Questions[position]);
//        }
//        return  list;
//    }
}
