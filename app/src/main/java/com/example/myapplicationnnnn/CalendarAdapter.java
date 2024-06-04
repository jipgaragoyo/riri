package com.example.myapplicationnnnn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.ViewHolder> {

    private List<CalendarDay> calendarDays;
    private OnItemClickListener onItemClickListener;
    private Context context;

    public CalendarAdapter(List<CalendarDay> calendarDays, OnItemClickListener onItemClickListener, Context context) {
        this.calendarDays = calendarDays;
        this.onItemClickListener = onItemClickListener;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_calendar_day, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CalendarDay calendarDay = calendarDays.get(position);

        holder.textViewDay.setText(String.valueOf(calendarDay.getDay()));
        if (calendarDay.isCurrentMonth()) {
            holder.textViewDay.setTextColor(ContextCompat.getColor(context, android.R.color.black));
        } else {
            holder.textViewDay.setTextColor(ContextCompat.getColor(context, android.R.color.darker_gray));
        }

        if (calendarDay.getImageUri() != null) {
            holder.imageView.setImageURI(calendarDay.getImageUri());
            holder.imageView.setVisibility(View.VISIBLE);
        } else {
            holder.imageView.setVisibility(View.GONE);
        }

        holder.itemView.setOnClickListener(v -> onItemClickListener.onItemClick(position));
    }

    @Override
    public int getItemCount() {
        return calendarDays.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewDay;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewDay = itemView.findViewById(R.id.textViewDay);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
