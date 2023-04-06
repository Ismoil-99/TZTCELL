package com.example.tztcell.model.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.tztcell.model.data.News
import com.example.tztcell.model.remote.apiservices.BaseApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class RepositoryImpl @Inject constructor (private val baseApiService: BaseApiService):RepositoryRequest {

    override fun getBusiness(key: String, country: String, category: String): Flow<News> {
            return flow {
                try {
                    val response = baseApiService.getNewsBusiness(key,country,category)
                    if (response.isSuccessful) {
                        if (response.code() == 1) {
                            emit(response.body()!!)
                        } else {
                            emit(
                                response.body()!!
                            )
                        }
                    } else {
                        //emit(Log.d("value","vass"))
                        Log.d("error3", response.message())
                    }
                } catch (e: HttpException) {
                    //emit(Resource.Error(message = e.message()))
                    Log.d("error3","${e.code()}")
                } catch (e: Throwable) {
                    //emit(Resource.Error(message = HumoApp.instance.getString(R.string.humo_service_error)))
                    Log.d("error3", "${e.message}")
                }}
    }
}