package rec.first.spine_fairy;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class SettingPageAdapter extends FragmentStatePagerAdapter {

    private Fragment[] arrFragments;

    public SettingPageAdapter(@NonNull FragmentManager fm, int behavior, Fragment[] arrFragments) {
        super(fm, behavior);
        this.arrFragments=arrFragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return arrFragments[position];
    }

    @Override
    public int getCount() {
        return arrFragments.length;
    }
}
