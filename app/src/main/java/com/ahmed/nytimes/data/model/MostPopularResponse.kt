package com.ahmed.nytimes.data.model

data class MostPopularResponse(
    var copyright: String,
    var num_results: Int,
    var results: List<MostPopularModel>,
    var status: String
) {

}