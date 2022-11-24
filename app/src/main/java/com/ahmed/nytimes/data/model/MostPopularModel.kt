package com.ahmed.nytimes.data.model
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue


@Parcelize
data class MostPopularModel(
    var byline: String,
    var published_date: String,
    var title: String,
    @SerializedName("media")
    var media: @RawValue List<Media>,
    var id: Long,
    var source: String,
    var uri: String,
    var url: String?
):Parcelable {
    data class Media(
        @SerializedName("media-metadata")
        var mediaMetadata: List<MediaMetadata>,
    ) {
        data class MediaMetadata(
            var url: String,
        )
    }
}