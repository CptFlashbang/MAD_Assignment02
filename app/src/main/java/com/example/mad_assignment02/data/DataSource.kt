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
            BurritoClass.createReadyMade(
                1,
                R.string.Pre_Made_01,
                R.string.Pre_Made_01_Description,
                8.99,
                R.string.Main_Filling_01,
                listOf(R.string.Additional_Filling_01),
                listOf(R.string.Sauce_01, R.string.Sauce_03),
                listOf(R.string.Salad_01)
            ),
            BurritoClass.createReadyMade(
                2,
                R.string.Pre_Made_02,
                R.string.Pre_Made_02_Description,
                9.99,
                R.string.Main_Filling_02,
                listOf(R.string.Additional_Filling_02),
                listOf(R.string.Sauce_02, R.string.Sauce_04),
                listOf(R.string.Salad_02)
            ),
            BurritoClass.createReadyMade(
                3,
                R.string.Pre_Made_03,
                R.string.Pre_Made_03_Description,
                7.99,
                R.string.Main_Filling_03,
                listOf(R.string.Additional_Filling_03),
                listOf(R.string.Sauce_02, R.string.Sauce_05, R.string.Sauce_06),
                listOf(R.string.Salad_03)
            ),
            BurritoClass.createReadyMade(
                4,
                R.string.Pre_Made_04,
                R.string.Pre_Made_04_Description,
                10.99,
                R.string.Main_Filling_04,
                listOf(R.string.Additional_Filling_04),
                listOf(R.string.Sauce_07),
                listOf(R.string.Salad_04, R.string.Salad_05)
            ),
            BurritoClass.createReadyMade(
                5,
                R.string.Pre_Made_05,
                R.string.Pre_Made_05_Description,
                8.49,
                R.string.Main_Filling_05,
                listOf(R.string.Additional_Filling_05),
                listOf(R.string.Sauce_08),
                listOf(R.string.Salad_05, R.string.Salad_06, R.string.Salad_07)
            ),
            BurritoClass.createReadyMade(
                6,
                R.string.Pre_Made_06,
                R.string.Pre_Made_06_Description,
                11.49,
                R.string.Main_Filling_06,
                listOf(R.string.Additional_Filling_06),
                listOf(R.string.Sauce_09, R.string.Sauce_10),
                listOf(R.string.Salad_03)
            ),
            BurritoClass.createReadyMade(
                7,
                R.string.Pre_Made_07,
                R.string.Pre_Made_07_Description,
                9.79,
                R.string.Main_Filling_07,
                listOf(R.string.Additional_Filling_08),
                listOf(R.string.Sauce_11),
                listOf(R.string.Salad_02, R.string.Salad_06, R.string.Salad_08)
            ),
            BurritoClass.createReadyMade(
                8,
                R.string.Pre_Made_08,
                R.string.Pre_Made_08_Description,
                11.99,
                R.string.Main_Filling_08,
                listOf(R.string.Additional_Filling_07),
                listOf(R.string.Sauce_12, R.string.Sauce_13),
                listOf(R.string.Salad_09)
            ),
            BurritoClass.createReadyMade(
                9,
                R.string.Pre_Made_09,
                R.string.Pre_Made_09_Description,
                10.49,
                R.string.Main_Filling_09,
                listOf(R.string.Additional_Filling_05),
                listOf(R.string.Sauce_08),
                listOf(R.string.Salad_06, R.string.Salad_10)
            ),
            BurritoClass.createReadyMade(
                10,
                R.string.Pre_Made_10,
                R.string.Pre_Made_10_Description,
                8.29,
                R.string.Main_Filling_10,
                listOf(R.string.Additional_Filling_01),
                listOf(R.string.Sauce_02, R.string.Sauce_14),
                listOf(R.string.Salad_01)
            )
        )
    }

data class BurritoClass(
    val id: Int,
    @StringRes val title: Int,
    @StringRes val description: Int?,
    val price: Double,
    val mainFilling: String,
    val additionalFillings: List<String>,
    val sauces: List<String>,
    val salads: List<String>
)
