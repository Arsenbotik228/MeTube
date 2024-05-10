package com.myself223.metube.ui.adapters.playlist_fragment_adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.myself223.metube.data.models.BaseMainResponse
import com.myself223.metube.data.models.ItemPlaylistDto
import com.myself223.metube.databinding.ItemPlaylistsBinding
import com.myself223.metube.ui.fragments.playlist.PlaylistsFragment

class PlaylistAdapter(playlistsFragment: PlaylistsFragment, private val click: Click) : ListAdapter<BaseMainResponse<ItemPlaylistDto>, PlaylistAdapter.HomeViewHolder>(
    HomeDiffUtill()
) {
    class HomeViewHolder(private val binding: ItemPlaylistsBinding) : ViewHolder(binding.root) {
        fun onBind(it: BaseMainResponse<ItemPlaylistDto>) {

            binding.itemNamePlaylist.text = it.items.get(1).snippetDto?.title
            binding.itemNamePlaylist.text = it.items.get(1).contentDetails?.itemCount?.toString()
            Glide.with(binding.root).load(it.items.get(1).snippetDto?.descriptions?.mediumDto?.url).centerCrop().into(binding.itemPlaylistPreview)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(ItemPlaylistsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val homeModel = getItem(position)
        holder.itemView.setOnClickListener {
            click.onClick(homeModel)
        }
        holder.onBind(homeModel)
    }

    class HomeDiffUtill : DiffUtil.ItemCallback<BaseMainResponse<ItemPlaylistDto>>() {
        override fun areItemsTheSame(
            oldItem: BaseMainResponse<ItemPlaylistDto>,
            newItem: BaseMainResponse<ItemPlaylistDto>
        ): Boolean {
           return oldItem == newItem

        }

        override fun areContentsTheSame(
            oldItem: BaseMainResponse<ItemPlaylistDto>,
            newItem: BaseMainResponse<ItemPlaylistDto>
        ): Boolean {
            return oldItem == newItem
        }
    }

    interface Click {
        fun onClick(model: BaseMainResponse<ItemPlaylistDto>)
    }
}
