package com.neobis.checkpointneobis.ui.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.neobis.checkpointneobis.model.NewsResponse
import com.neobis.checkpointneobis.repository.NewsRepository
import kotlinx.coroutines.launch


class NewsViewModel(
    app: Application,
    private val newsRepository: NewsRepository
) : AndroidViewModel(app) {

    //для домашней страницы
    val breakingNews: MutableLiveData<NewsResponse> = MutableLiveData()
    private var breakingNewsPage = 1

    init {
        getNews("us")
    }

    private fun getNews(countryCode: String) {
        viewModelScope.launch {
            val response = newsRepository.getBreakingNews(countryCode, breakingNewsPage)
            if (response.isSuccessful) {
                breakingNews.postValue(response.body())
            }
        }
    }
}