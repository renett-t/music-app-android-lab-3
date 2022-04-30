package ru.itis.musicapp.presentation.extension

import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

fun Fragment.findNavigationController(id: Int) : NavController {
    return (requireActivity().supportFragmentManager.findFragmentById(id) as NavHostFragment).navController
}
