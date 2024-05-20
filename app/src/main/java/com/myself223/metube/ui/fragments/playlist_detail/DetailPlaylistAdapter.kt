package com.myself223.metube.ui.fragments.playlist_detail

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.myself223.metube.data.models.ItemPlaylistDto
import com.myself223.metube.databinding.ItemPlaylistBinding
import com.myself223.metube.databinding.ItemPlaylistVideoBinding
import com.myself223.metube.ui.utils.loadImageURL

class DetailPlaylistAdapter(/*val context: Context,private val click:(id:String)->Unit*/) : ListAdapter<ItemPlaylistDto, DetailPlaylistAdapter.DetailPlaylistViewHolder>(
    PlaylistDiffUtill()
) {
    class DetailPlaylistViewHolder(private val binding: ItemPlaylistVideoBinding) : ViewHolder(binding.root) {
        fun onBind(it:ItemPlaylistDto) {

            binding.itemVideoName.text = it.videoOwnerChannelTitle
            binding.itemTime.text = it.contentDetails?.endAt
            binding.itemVideoPreview.loadImageURL(it.snippetDto?.thumbnails?.mediumDto?.url)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailPlaylistViewHolder {
        return DetailPlaylistViewHolder(ItemPlaylistVideoBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: DetailPlaylistViewHolder, position: Int) {
        val DetailPlaylistModel = getItem(position)
        holder.itemView.setOnClickListener {
        }
        holder.onBind(DetailPlaylistModel)
    }



    class PlaylistDiffUtill : DiffUtil.ItemCallback<ItemPlaylistDto>() {


        override fun areItemsTheSame(oldItem: ItemPlaylistDto, newItem: ItemPlaylistDto): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: ItemPlaylistDto,
            newItem: ItemPlaylistDto
        ): Boolean {

            return oldItem == newItem
        }
    }

    interface Click {
        fun onClick(model:ItemPlaylistDto)
    }
}
