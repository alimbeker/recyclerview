package com.example.recyclerview

import com.example.recyclerview.decoration.dp

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView



fun RecyclerView.swipeToLike(likeAction: (Int) -> Unit) {
    ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.START) {
        val rectangleLength = 97.dp
        val maxScroll = 80.dp
        val image = BitmapFactory.decodeResource(resources, R.drawable.like)
            ?: throw IllegalArgumentException("Failed to load image resource")

        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            return false
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if (viewHolder is ItemListAdapter.JobViewHolder) {
                likeAction.invoke(viewHolder.adapterPosition)
            }
        }

        override fun onChildDraw(
            c: Canvas,
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            dX: Float,
            dY: Float,
            actionState: Int,
            isCurrentlyActive: Boolean
        ) {
            if (viewHolder is ItemListAdapter.JobViewHolder && actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
                with(viewHolder.itemView) {
                    val paint = Paint(Paint.ANTI_ALIAS_FLAG)
                    val scrollOffset = (-dX).toInt()

                    if (scrollOffset > 10) {
                        paint.color = ContextCompat.getColor(context, android.R.color.holo_red_light)
                        val back = RectF(
                            right.toFloat() - rectangleLength,
                            top.toFloat(),
                            right.toFloat(),
                            bottom.toFloat()
                        )
                        c.drawRect(back, paint)
                    }

                    if (scrollOffset < maxScroll) {
                        super.onChildDraw(
                            c,
                            recyclerView,
                            viewHolder,
                            -scrollOffset.toFloat(),
                            dY,
                            actionState,
                            isCurrentlyActive
                        )
                    }

                    if (scrollOffset > 250.dp) {
                        val iconRect = RectF(
                            right.toFloat() - 50.dp,
                            top.toFloat() + 28.dp,
                            right.toFloat() - 30.dp,
                            bottom.toFloat() - 30.dp
                        )
                        c.drawBitmap(image, null, iconRect, paint)
                    }
                }
            }
        }
    }).attachToRecyclerView(this)
}


