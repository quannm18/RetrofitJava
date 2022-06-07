package com.quannm18.testretrofit.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.quannm18.testretrofit.Login.LoginUser;
import com.quannm18.testretrofit.R;
import com.quannm18.testretrofit.RCVActivity;
import com.quannm18.testretrofit.api.ApiLogin;
import com.quannm18.testretrofit.model.Message;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserHolder> {
    private List<LoginUser> userList;

    public UserAdapter(List<LoginUser> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,null,false);
        return new UserHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder holder, int position) {
        final LoginUser  user = userList.get(position);
        holder.textView3.setText(user.toString());
        
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApiLogin.apiLogin.postUpdate(user.getId()+"","1111111111","999","999","22/12/2222","999","loser")
                        .enqueue(new Callback<Message>() {
                            @Override
                            public void onResponse(Call<Message> call, Response<Message> response) {
                                Toast.makeText(view.getContext(), ""+response.body().getMessage(), Toast.LENGTH_SHORT).show();

                                userList.clear();
                                userList = (getListUser(view.getContext()));
//                                notifyDataSetChanged();
//                                notifyItemRangeChanged(0,userList.size());
//                                notifyItemChanged(holder.getAdapterPosition());
                            }

                            @Override
                            public void onFailure(Call<Message> call, Throwable t) {
                                Toast.makeText(view.getContext(), "Failed", Toast.LENGTH_SHORT).show();
                                Log.e("onFailure: ",t.getMessage()+"" );
                                notifyDataSetChanged();
                            }
                        });
            }
        });
    }
    public List<LoginUser> getListUser(Context context) {
        List<LoginUser> listUser = new ArrayList<>();

        ApiLogin.apiLogin.getUserList().enqueue(new Callback<List<LoginUser>>() {
            @Override
            public void onResponse(Call<List<LoginUser>> call, Response<List<LoginUser>> response) {
                Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
                List<LoginUser> userList = response.body();
                for (LoginUser user:
                        userList) {
                    listUser.add(user);
                    notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<LoginUser>> call, Throwable t) {
                Log.e("error",call+"");

            }
        });
        return listUser;
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class UserHolder extends RecyclerView.ViewHolder {
        private TextView textView3;

        public UserHolder(@NonNull View itemView) {
            super(itemView);
            textView3 = (TextView) itemView.findViewById(R.id.textView3);

        }
    }
}
