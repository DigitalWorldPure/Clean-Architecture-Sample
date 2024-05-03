package com.example.domain.pagingsources

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.data.repository.PokemonsRemoteRepository
import com.example.domain.mapper.mapData
import com.example.domain.models.PokemonShortData

class PokemonsPagingSource (
    private val sampleRepository: PokemonsRemoteRepository
) : PagingSource<Int, PokemonShortData>() {

    override fun getRefreshKey(state: PagingState<Int, PokemonShortData>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PokemonShortData> {
        val position = params.key ?: 1
        val data = sampleRepository.getPokemonPaged(position, params.loadSize).map(::mapData)
        val totalCount = params.loadSize * 30
        return LoadResult.Page(
            data = data,
            prevKey = if (position == 1) null else position - 1,
            nextKey = if (data.isEmpty() || position == (totalCount/params.loadSize) + 1) null
            else {
                if (position == 1) INITIAL_PAGE_MULTIPLIER + 1
                else position + 1
            }
        )
    }

    companion object {
        const val INITIAL_PAGE_MULTIPLIER = 3
    }
}
