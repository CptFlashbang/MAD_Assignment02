package com.example.mad_assignment02.data

import androidx.annotation.StringRes
import com.example.mad_assignment02.R

object DataSource {
    val mainFillings = mapOf(
        "GrilledChicken" to R.string.Main_Filling_01,
        "ChipotleSteak" to R.string.Main_Filling_02,
        "Jackfruit" to R.string.Main_Filling_03,
        "Shrimp" to R.string.Main_Filling_04,
        "Chickpeas" to R.string.Main_Filling_05,
        "KaluaPork" to R.string.Main_Filling_06,
        "BuffaloChicken" to R.string.Main_Filling_07,
        "Brisket" to R.string.Main_Filling_08,
        "Lamb" to R.string.Main_Filling_09,
        "SweetPotato" to R.string.Main_Filling_10
    )
    val additionalFillings = mapOf(
        "CilantroRice" to R.string.Additional_Filling_01,
        "CaramelizedOnions" to R.string.Additional_Filling_02,
        "Quinoa" to R.string.Additional_Filling_03,
        "JasmineRice" to R.string.Additional_Filling_04,
        "FetaCheese" to R.string.Additional_Filling_05,
        "CoconutLimeRice" to R.string.Additional_Filling_06,
        "GrilledPeppersOnions" to R.string.Additional_Filling_07,
        "BlueCheese" to R.string.Additional_Filling_08
    )
    val sauces = mapOf(
        "MangoSalsa" to R.string.Sauce_01,
        "CornBeanSalsa" to R.string.Sauce_02,
        "MangoHabanero" to R.string.Sauce_03,
        "CilantroLimeDressing" to R.string.Sauce_04,
        "Guacamole" to R.string.Sauce_05,
        "LimeJuice" to R.string.Sauce_06,
        "SrirachaPeanut" to R.string.Sauce_07,
        "Tzatziki" to R.string.Sauce_08,
        "PineappleSalsa" to R.string.Sauce_09,
        "TeriyakiGlaze" to R.string.Sauce_10,
        "BuffaloRanch" to R.string.Sauce_11,
        "PicoDeGallo" to R.string.Sauce_12,
        "ChipotleAioli" to R.string.Sauce_13,
        "CilantroCrema" to R.string.Sauce_14
    )
    val salads = mapOf(
        "Avocado" to R.string.Salad_01,
        "ShreddedLettuce" to R.string.Salad_02,
        "PurpleCabbage" to R.string.Salad_03,
        "PeanutSlaw" to R.string.Salad_04,
        "CucumberRibbons" to R.string.Salad_05,
        "DicedTomatoes" to R.string.Salad_06,
        "Olives" to R.string.Salad_07,
        "CelerySlaw" to R.string.Salad_08,
        "Corn" to R.string.Salad_09,
        "Spinach" to R.string.Salad_10
    )

    val ReadyMadeBurritos = arrayListOf(
        BurritoClass(
            1,
            R.string.Pre_Made_01,
            R.string.Pre_Made_01_Description,
            8.99,
            "GrilledChicken",
            listOf("CilantroRice"),
            listOf("MangoSalsa", "MangoHabanero"),
            listOf("Avocado")
        ),
        BurritoClass(
            2,
            R.string.Pre_Made_02,
            R.string.Pre_Made_02_Description,
            9.99,
            "ChipotleSteak",
            listOf("CaramelizedOnions"),
            listOf("CornBeanSalsa", "CilantroLimeDressing"),
            listOf("ShreddedLettuce")
        ),
        BurritoClass(
            3,
            R.string.Pre_Made_03,
            R.string.Pre_Made_03_Description,
            7.99,
            "Jackfruit",
            listOf("Quinoa"),
            listOf("CornBeanSalsa", "Guacamole", "LimeJuice"),
            listOf("PurpleCabbage")
        ),
        BurritoClass(
            4,
            R.string.Pre_Made_04,
            R.string.Pre_Made_04_Description,
            10.99,
            "Shrimp",
            listOf("JasmineRice"),
            listOf("SrirachaPeanut"),
            listOf("PeanutSlaw", "CucumberRibbons")
        ),
        BurritoClass(
            5,
            R.string.Pre_Made_05,
            R.string.Pre_Made_05_Description,
            8.49,
            "Chickpeas",
            listOf("FetaCheese"),
            listOf("Tzatziki"),
            listOf("CucumberRibbons", "DicedTomatoes", "Olives")
        ),
        BurritoClass(
            6,
            R.string.Pre_Made_06,
            R.string.Pre_Made_06_Description,
            11.49,
            "KaluaPork",
            listOf("CoconutLimeRice"),
            listOf("PineappleSalsa", "TeriyakiGlaze"),
            listOf("PurpleCabbage")
        ),
        BurritoClass(
            7,
            R.string.Pre_Made_07,
            R.string.Pre_Made_07_Description,
            9.79,
            "BuffaloChicken",
            listOf("BlueCheese"),
            listOf("BuffaloRanch"),
            listOf("ShreddedLettuce", "DicedTomatoes", "CelerySlaw")
        ),
        BurritoClass(
            8,
            R.string.Pre_Made_08,
            R.string.Pre_Made_08_Description,
            11.99,
            "Brisket",
            listOf("GrilledPeppersOnions"),
            listOf("PicoDeGallo", "ChipotleAioli"),
            listOf("Corn")
        ),
        BurritoClass(
            9,
            R.string.Pre_Made_09,
            R.string.Pre_Made_09_Description,
            10.49,
            "Lamb",
            listOf("FetaCheese"),
            listOf("Tzatziki"),
            listOf("DicedTomatoes", "Spinach")
        ),
        BurritoClass(
            10,
            R.string.Pre_Made_10,
            R.string.Pre_Made_10_Description,
            8.29,
            "SweetPotato",
            listOf("CilantroRice"),
            listOf("CornBeanSalsa", "CilantroCrema"),
            listOf("Avocado")
        )
    )
}

data class BurritoClass(
    val id: Int,
    @StringRes val title: Int,
    @StringRes val description: Int,
    val price: Double,
    val mainFilling: String,
    val additionalFillings: List<String>,
    val sauces: List<String>,
    val salads: List<String>
)
{}
