package com.mu.fishermannotes.presentation.screen.photo

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import com.mu.fishermannotes.presentation.navigation.Destinations
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SliderViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    val args = savedStateHandle.toRoute<Destinations.SliderDestination>()
    val path = args.path
    val startPhoto = args.startPhoto
}