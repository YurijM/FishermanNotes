package com.mu.fishermannotes.screens.location

import com.mu.fishermannotes.model.entity.LocationEntity

sealed class LocationEvent {
    data class OnShowEditDialog(val location: LocationEntity): LocationEvent()
    data class OnShowDeleteDialog(val location: LocationEntity): LocationEvent()
    data class OnItemClick(val route: String): LocationEvent()
    object OnItemSave: LocationEvent()
}
