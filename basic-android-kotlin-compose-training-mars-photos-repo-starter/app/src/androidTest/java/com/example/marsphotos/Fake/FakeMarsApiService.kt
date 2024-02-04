package com.example.marsphotos.Fake

import com.example.marsphotos.model.MarsPhoto
import com.example.marsphotos.network.MarsApiService

class FakeMarsApiService: MarsApiService {
    override suspend fun getPhotos(): List<MarsPhoto> {
        return FakeDataSource.photosList
    }
}