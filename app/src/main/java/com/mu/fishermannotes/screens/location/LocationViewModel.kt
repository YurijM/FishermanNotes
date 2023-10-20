package com.mu.fishermannotes.screens.location

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mu.fishermannotes.data.repository.location.LocationRepository
import com.mu.fishermannotes.model.entity.LocationEntity
import com.mu.fishermannotes.utils.DialogControllerLocation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(
    private val repository: LocationRepository
) : ViewModel(), DialogControllerLocation {
    private var location = LocationEntity(
        id = null,
        location = ""
    )

    override var openDialog = mutableStateOf(false)
        private set

    override var dialogTitle = mutableStateOf("")
        private set

    override var showEditableFields = mutableStateOf(false)
        private set

    override var editLocation = mutableStateOf("Не указано")
        private set

    fun onEvent(event: LocationEvent) {
        when (event) {
            is LocationEvent.OnShowDeleteDialog -> {
                location = event.location
            }
            is LocationEvent.OnShowEditDialog -> {
                location = event.location
            }
            is LocationEvent.OnItemClick -> {

            }
            is LocationEvent.OnItemSave -> {
                viewModelScope.launch {
                    repository.insert(location)
                }
            }
        }
    }
}