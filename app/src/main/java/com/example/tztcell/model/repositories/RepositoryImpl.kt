package com.example.tztcell.model.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.tztcell.model.Resource
import com.example.tztcell.model.data.News
import com.example.tztcell.model.remote.apiservices.BaseApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class RepositoryImpl @Inject constructor (private val baseApiService: BaseApiService):RepositoryRequest {

    override fun getBusiness(key: String, country: String, category: String): Flow<Resource<News>> {
        return flow {
            emit(Resource.Loading())
            try {
                val response = baseApiService.getNewsBusiness(key,country,category)
                if (response.isSuccessful) {
                    if (response.code() == 200) {
                        emit(Resource.Success(response.body()!!))
                    } else {
                        emit(
                            Resource.Error(
                                message = response.message() ?: response.code()
                                    .toString()
                            )
                        )
                    }
                } else {
                    emit(Resource.Error(message = "Error: ${response.code()}"))
                }

            }catch (e: HttpException){
                Log.d("error2","${e.message}")

            }catch (e: Throwable){
                Log.d("error2","${e.message}")

            }
    }
    }

    override fun getTechnology(
        key: String,
        country: String,
        category: String
    ): Flow<Resource<News>> {
        return flow {
            emit(Resource.Loading())
            try {
                val response = baseApiService.getNewsTechnology(key,country,category)
                if (response.isSuccessful) {
                    if (response.code() == 200) {
                        emit(Resource.Success(response.body()!!))
                    } else {
                        emit(
                            Resource.Error(
                                message = response.message() ?: response.code()
                                    .toString()
                            )
                        )
                    }
                } else {
                    emit(Resource.Error(message = "Error: ${response.code()}"))
                    Log.d("error2","${response.code()}")
                }

            }catch (e: HttpException){
                Log.d("error2","${e.message}")

            }catch (e: Throwable){
                Log.d("error2","${e.message}")

            }
        }
    }

    override fun getSport(key: String, country: String, category: String): Flow<Resource<News>> {
        return flow {
            emit(Resource.Loading())
            try {
                val response = baseApiService.getNewsSport(key,country,category)
                if (response.isSuccessful) {
                    if (response.code() == 200) {
                        emit(Resource.Success(response.body()!!))
                        //Log.d("error2","${response.code()}")
                    } else {
                        emit(
                            Resource.Error(
                                message = response.message() ?: response.code()
                                    .toString()
                            )
                        )
                    }
                } else {
                    emit(Resource.Error(message = "Error: ${response.code()}"))
                    Log.d("error2","${response.code()}")
                }

            }catch (e: HttpException){
                Log.d("error2","${e.message}")

            }catch (e: Throwable){
                Log.d("error2","${e.message}")

            }
        }
    }

}