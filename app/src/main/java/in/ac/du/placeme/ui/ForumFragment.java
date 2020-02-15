package in.ac.du.placeme.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import in.ac.du.placeme.R;

public class ForumFragment extends Fragment {
    @Override  public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstance) {
        return inflater.inflate(R.layout.fragment_forum, parent, false);
    }
}
