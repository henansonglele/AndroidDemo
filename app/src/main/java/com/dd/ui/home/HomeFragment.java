package com.dd.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.dd.R;
import com.dd.utils.ImageManager;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    ImageView imageview_bg;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        imageview_bg = root.findViewById(R.id.imageview_bg);

        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        ImageManager.loadImageFromNet(getContext(),"https://pics6.baidu.com/feed/e61190ef76c6a7efa7dc53ce842f7356f1de66b9.jpeg?token=edf26f1943b9dfb727a884974dfd1e16&s=9F1004C7DA21E0CE181690B10300D019",imageview_bg);
        return root;
    }
}