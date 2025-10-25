package com.example.travelmarket.logic.data.repositories

import com.example.travelmarket.core.base.BaseRepository
import com.example.travelmarket.core.network.NetworkResult
import com.example.travelmarket.logic.data.mappers.DestinationMapper
import com.example.travelmarket.logic.data.remote.destinations.DestinationsApiService
import com.example.travelmarket.logic.domain.models.Destination
import com.example.travelmarket.logic.domain.repositories.DestinationsRepository

class DestinationsRepositoryImpl(
    private val apiService: DestinationsApiService
) : BaseRepository(), DestinationsRepository {

    override suspend fun getDestinations(
        country: String?,
        continent: String?,
        isPopular: Boolean?,
        bestSeason: String?,
        search: String?,
        ordering: String?,
        page: Int?
    ): NetworkResult<List<Destination>> {
        val result = executeApiCall {
            apiService.getDestinations(
                country = country,
                continent = continent,
                isPopular = isPopular,
                bestSeason = bestSeason,
                search = search,
                ordering = ordering,
                page = page
            )
        }

        return when (result) {
            is NetworkResult.Success -> {
                val destinations = DestinationMapper.toDomainList(result.data.results)
                NetworkResult.Success(destinations)
            }
            is NetworkResult.Error -> NetworkResult.Error(result.message, result.code)
            is NetworkResult.Loading -> NetworkResult.Loading
        }
    }
}