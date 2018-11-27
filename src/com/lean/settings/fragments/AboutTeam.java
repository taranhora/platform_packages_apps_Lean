/*
 * Copyright © 2018 LeanOS Project
 * Date: 27.11.2018
 * Time: 12:31
 * Author: @darkbeast69 <guptaaryan189@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.lean.settings.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;

import com.android.internal.logging.nano.MetricsProto;

import com.lean.settings.fragments.common.AboutTeamAdapter;
import com.lean.settings.fragments.common.AboutTeamAdapter.About;
import com.lean.settings.fragments.common.AboutTeamAdapter.Dev;
import com.lean.settings.fragments.common.AboutTeamAdapter.Team;
import com.lean.settings.fragments.common.AboutTeamAdapter.Header;
import com.lean.settings.fragments.common.AboutTeamAdapter.OnClickListener;

import java.util.ArrayList;
import java.util.List;

public class AboutTeam extends SettingsPreferenceFragment {

	private List<AboutTeamAdapter.About> list = new ArrayList<>();

	@Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.about_team, null);
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getActivity().setTitle(R.string.about_team_title);
        initList();

        RecyclerView recyclerView = getView().findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new AboutTeamAdapter(list, new AboutTeamAdapter.OnClickListener() {
            @Override
            public void OnClick(String url) {
                if (!url.isEmpty()) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(browserIntent);
                }
            }
        }));
    }

    @Override
    public int getMetricsCategory() {
        return MetricsProto.MetricsEvent.LEAN;
    }

    private void initList() {
        List<AboutTeamAdapter.Dev> team = new ArrayList<>();
        team.add(new AboutTeamAdapter.Dev(
                "Aryan Gupta",
                "Founder | Core Developer",
                "https://avatars3.githubusercontent.com/u/29354581?s=400&v=4",
                "",
                "https://github.com/darkbeast69",
                "https://t.me/Darkbeast_69"
        ));
        team.add(new AboutTeamAdapter.Dev(
                "Taran Hora",
                "Lean Developer",
                "https://avatars0.githubusercontent.com/u/25039507?s=400&v=4",
                "https://forum.xda-developers.com/member.php?u=5918218",
                "https://github.com/taranhora",
                "https://t.me/taran107"
        ));
        team.add(new AboutTeamAdapter.Dev(
                "Jyotiraditya Panda",
                "Developer | Site Designer | Core Team",
                "https://avatars3.githubusercontent.com/u/39813864?s=460&v=4",
                "",
                "https://github.com/StrangeNoob",
                "https://t.me/StrangeNoob"
        ));
        team.add(new AboutTeamAdapter.Dev(
                "AryanataAndi(Ryan)",
                "UI/UX Designer",
                "https://raw.githubusercontent.com/StrangeNoob/private/master/photo_2018-11-22_12-40-23.jpg",
                "https://forum.xda-developers.com/member.php?u=7477838",
                "",
                "https://www.telegram.me/AryanataAndi17"
        ));
        list.add(new AboutTeamAdapter.Team(
                        "https://github.com/LeanOS-Project",
                        "https://t.me/lean_os",
                        team

                )
        );
        list.add(new AboutTeamAdapter.Header());
        list.add(new AboutTeamAdapter.Maintainer(
                        "Xiaomi Redmi Note 5 Pro(Whyred)",
                        new AboutTeamAdapter.Dev(
                                "Rashed Sahaji",
                                "",
                                "https://avatars1.githubusercontent.com/u/42634886?s=400&v=4",
                                "https://forum.xda-developers.com/redmi-note-5-pro/development/rom-leanos-rom-v0-1-t3867010",
                                "",
                                "https://www.telegram.me/RashedSahaji"
                        )
                )
        );
        list.add(new AboutTeamAdapter.Maintainer(
                        "Asus Zenfone Max Pro M1(X00T/D)",
                        new AboutTeamAdapter.Dev(
                                "Bablu",
                                "",
                                "https://avatars2.githubusercontent.com/u/33689904?s=400&u=7126594010c5289e73cbb2ad5edea392b3511890&v=4",
                                "https://forum.xda-developers.com/asus-zenfone-max-pro-m1/development/9-0-rom-leanos-pie14-11-2018-t3867369/page3",
                                "https://github.com/bablusss",
                                ""
                        )
                )
        );
    }
}
