package com.example.webtooninfoapp.utils

import com.example.webtooninfoapp.R
import com.example.webtooninfoapp.Webtoon
import com.example.webtooninfoapp.entities.Characters
import com.example.webtooninfoapp.entities.DetailedWebtoonInfo

object WebtoonData {

    val actionFantasyWebtoons = listOf(
        Webtoon("Solo Leveling", "A hunter’s journey to become the strongest.", R.drawable.solo_leveling),
        Webtoon("Tower of God", "A thrilling adventure through a mysterious tower.", R.drawable.tower_of_god),
        Webtoon("Hardcore Leveling Warrior", "A powerful warrior’s comeback in a virtual world.", R.drawable.leveling_warrior),
        Webtoon("Noblesse", "A noble vampire awakens to protect humanity.", R.drawable.noblesse),
        Webtoon("The God of High School", "Martial arts tournament with powerful competitors.", R.drawable.god_of_high_school),
        Webtoon("Second Life Ranker", "A man’s quest for revenge in a new life.", R.drawable.second_life_ranker),
        Webtoon("Eleceed", "A street cat with extraordinary powers.", R.drawable.eleceed),
        Webtoon("The Advanced Player of the Tutorial Tower", "A unique twist on the tutorial genre.", R.drawable.advanced_player),
        Webtoon("Leveling Up With The Gods", "Adventures in a world governed by gods.", R.drawable.level_up),
        Webtoon("Villain to Kill", "A twist on the villain redemption arc.", R.drawable.villain_to_kill),
        Webtoon("Hero Killer", "A story about the ultimate hero killer.", R.drawable.hero_killer),
    )

    val detailedInfoAboutWebtoons = mapOf(
        "Solo Leveling" to DetailedWebtoonInfo(
            detailedDescription = "Solo Leveling follows the journey of Sung Jin-Woo as he rises from the weakest hunter to the most powerful being." +
                    "\n In a world where hunters — human warriors who possess supernatural abilities — must battle deadly monsters to protect mankind from certain annihilation, a notoriously weak hunter named Sung Jinwoo finds himself in a seemingly endless struggle for survival. One day, after narrowly surviving an overwhelmingly powerful double dungeon that nearly wipes out his entire party, a mysterious program called the System chooses him as its sole player and in turn, gives him the unique ability to level up in strength. This is something no other hunter is able to do, as a hunter's abilities are set once they awaken. \n Jinwoo then sets out on a journey as he fights against all kinds of enemies, both man and monster, to discover the secrets of the dungeons and the true source of his powers. He soon discovers that he has been chosen to inherit the position of Shadow Monarch, essentially turning him into an immortal necromancer who has absolute rule over the dead. He is the only Monarch who fights to save humanity, as the other Monarchs are all trying to kill him and wipe out the humans.",
            majorCharacters = listOf(
                Characters("Sung Jin-Woo", R.drawable.sung_jun_wu,"Sung Jinwoo (성진우, Seong Jin-Wu) is the main protagonist of Solo Leveling. He is the strongest hunter in the world and the second Shadow Monarch."),
                Characters("Cha Hae-In", R.drawable.cha_hae_in,"Cha Hae-In (차해인) is a Korean S-Rank Hunter and the Vice-Guild Master of the Hunters Guild. She is also the wife of Sung Jinwoo and the mother of their son Sung Suho.")
            ),
            minorCharacters = listOf(
                Characters("Go Gun-Hee", R.drawable.go_gun_hee,"Go Gun-Hee (고건희) was a South Korean S-Rank Hunter and the Chairman of the Korean Hunters Association. Despite his immense power, his body has become weak due to old age, making him incapable of fighting."),
                Characters("Yoo Jin-Ho", R.drawable.yoo_jin_ho,"Yoo Jinho (유진호) is a Korean D-Rank Hunter and the Vice-Guild Master of the Ahjin Guild.")
            )
        )
    )


//    val romanceFantasyWebtoons = listOf(
//        Webtoon("Lore Olympus", "A retelling of Hades and Persephone.", R.drawable.lore_olympus),
//        Webtoon("The Remarried Empress", "A tale of love, betrayal, and royal politics.", "url2"),
//        Webtoon("Leveling Up My Husband to the Max", "A unique twist on the romantic fantasy genre.", "url3"),
//        Webtoon("I’m the Queen in this Life", "A story of power and love.", "url4"),
//        Webtoon("The Witch and the Bull", "A magical romance between a witch and a bull.", "url5"),
//        Webtoon("From A Knight to A Lady", "A knight's journey in a lady's body.", "url6"),
//        Webtoon("For My Derelict Favorite", "A unique romance with unexpected twists.", "url7"),
//        Webtoon("Eternal Nocturnal", "A love story with supernatural elements.", "url8"),
//        Webtoon("Act Like You Love Me!", "A romantic comedy filled with misunderstandings.", "url9"),
//        Webtoon("My In-Laws Are Obsessed With Me", "A humorous take on family dynamics.", "url10"),
//        Webtoon("Suitor Armor", "A unique story about love and protection.", "url11"),
//        Webtoon("Castle Swimmer", "A romance set in a fantasy castle.", "url12"),
//        Webtoon("SubZero", "A fantasy romance involving ice and fire.", "url13"),
//        Webtoon("Your Throne", "A tale of political intrigue and romance.", "url14"),
//    )
//
//
//    val adventureFantasyWebtoons = listOf(
//        Webtoon("A Returner’s Magic Should Be Special", "A tale of magic and adventure.", "url1"),
//        Webtoon("Omniscient Reader’s Viewpoint", "A unique take on fantasy adventures.", "url2"),
//        Webtoon("The World After The Fall", "Surviving in a new world filled with challenges.", "url3"),
//        Webtoon("The Greatest Estate Developer", "A story of ambition and development.", "url4"),
//        Webtoon("The Wrath & the Dawn", "A tale of revenge and love in a fantasy setting.", "url5"),
//        Webtoon("Tricked Into Becoming the Heroine’s Stepmother", "A twist on the stepmother trope.", "url6"),
//        Webtoon("The First Night With the Duke", "A romantic adventure in a noble setting.", "url7"),
//        Webtoon("Like Wind On A Dry Branch", "A journey filled with introspection and growth.", "url8"),
//        Webtoon("Everywhere & Nowhere", "A story of adventures in unexpected places.", "url9"),
//        Webtoon("Fluffy Boyfriend", "A lighthearted adventure with a cute twist.", "url10"),
//        Webtoon("Hooky", "A unique adventure involving magic and discovery.", "url11"),
//        Webtoon("Kubera", "A story filled with mythical creatures and adventures.", "url12"),
//        Webtoon("DICE", "A game that affects reality and the adventure that follows.", "url13"),
//        Webtoon("Lumine", "A journey of light and adventure.", "url14")
//    )

}