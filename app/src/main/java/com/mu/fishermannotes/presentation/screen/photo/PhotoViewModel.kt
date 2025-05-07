package com.mu.fishermannotes.presentation.screen.photo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import com.mu.fishermannotes.presentation.navigation.Destinations
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PhotoViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    var path by mutableStateOf(savedStateHandle.toRoute<Destinations.PhotoDestination>().path)
}