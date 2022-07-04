package br.com.dio.app.repositories.data.repositories

import br.com.dio.app.repositories.core.RemoteException
import br.com.dio.app.repositories.data.services.GitHubService
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class RepoRepositoryImpl(private val service: GitHubService) : RepoRepository{

    override suspend fun listRepositories(user: String) = flow {
        try {
            val listRepositories = service.listRepositories(user)
            emit(listRepositories)
        } catch (e: HttpException) {
            throw RemoteException(e.message ?: "Não foi possível fazer a busca no momento!")
        }
    }
}