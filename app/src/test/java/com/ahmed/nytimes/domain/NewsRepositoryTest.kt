package com.ahmed.nytimes.domain

import com.ahmed.nytimes.data.model.MostPopularModel
import com.ahmed.nytimes.data.utils.Resource
import org.junit.Before

class NewsRepositoryTest : NewsRepository {

    private  var mediaMetadata1=MostPopularModel.Media.MediaMetadata("https://static01.nyt.com/images/2022/11/14/multimedia/14nat-idaho-deaths-1-b274/14nat-idaho-deaths-1-b274-thumbStandard.jpg")
    private  var mediaMetadata2=MostPopularModel.Media.MediaMetadata("https://static01.nyt.com/images/2022/11/18/multimedia/18worldcup-beer-1-0e28/18worldcup-beer-1-0e28-thumbStandard.jpg")
    private  var mediaMetadata3=MostPopularModel.Media.MediaMetadata("https://static01.nyt.com/images/2022/11/18/business/18twitter-1/18twitter-1-thumbStandard.jpg")
    private  var mediaMetadata4=MostPopularModel.Media.MediaMetadata("https://static01.nyt.com/images/2022/11/19/business/18holmes-sentence1-print/18holmes-sentence-1-thumbStandard.jpg")
    private  var mediaMetadataList = listOf(mediaMetadata1,mediaMetadata2,mediaMetadata3,mediaMetadata4)
    private val media =  MostPopularModel.Media(mediaMetadataList)
    private  var fakePopularModel: MostPopularModel =
    MostPopularModel(
    "By Dave Philipps",
    "2022-11-21",
    "Army Veteran Went Into ‘Combat Mode’ to Disarm the Club Q Gunman",
    listOf(media),
    100000008649420,
    "New York Times",
    "nyt://article/e49807c9-a281-5a71-b6c5-ea24975030ed",
    "https://www.nytimes.com/2022/11/21/us/colorado-springs-shooting-club-q-hero.html"
    )
    @Before
    fun setUp() {
        fakePopularModel =
            MostPopularModel(
                "By Dave Philipps",
                "2022-11-21",
                "Army Veteran Went Into ‘Combat Mode’ to Disarm the Club Q Gunman",
                listOf(media),
                100000008649420,
                "New York Times",
                "nyt://article/e49807c9-a281-5a71-b6c5-ea24975030ed",
                "https://www.nytimes.com/2022/11/21/us/colorado-springs-shooting-club-q-hero.html"
            )
    }

    override suspend fun getNewsFromApis(): Resource<List<MostPopularModel>> {

        return Resource.Success(listOf(fakePopularModel) )
    }

}