package com.aditasha.rawgio.core.domain.usecase

import com.aditasha.rawgio.core.data.Resource
import com.aditasha.rawgio.core.domain.model.Favorite
import com.aditasha.rawgio.core.domain.model.Game
import com.aditasha.rawgio.core.domain.repository.IGameRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GameInteractor @Inject constructor(private val gameRepository: IGameRepository) :
    GameUseCase {
    override fun getListGames(query: String) = gameRepository.getListGames(query)

    override fun getFavoriteGame(): Flow<List<Favorite>> = gameRepository.getFavoriteGame()

    override fun getFavoriteGameById(gameId: Int): Flow<Favorite?> = gameRepository.getFavoriteGameById(gameId)

    override fun getGameDetail(gameId: Int): Flow<Resource<Game>> =
        gameRepository.getGameDetail(gameId)

    override suspend fun insertFavoriteGame(favorite: Favorite) =
        gameRepository.insertFavoriteGame(favorite)

    override suspend fun deleteFavoriteGame(gameId: Int) = gameRepository.deleteFavoriteGame(gameId)


}