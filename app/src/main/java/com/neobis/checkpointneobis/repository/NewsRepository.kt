package com.neobis.checkpointneobis.repository

import com.neobis.checkpointneobis.api.RetrofitInstance

class NewsRepository() {

    suspend fun getBreakingNews(countryCode: String, page: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, page)

}