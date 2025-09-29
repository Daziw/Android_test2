package com.example.test2;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity4 extends AppCompatActivity {

    // 顶部卡片
    private CardView fluidsCard;
    private CardView eventsCard;
    private CardView openWayCard;
    private CardView travelerCard;
    private CardView hasesCard;

    // 底部导航
    private View homeNav;
    private View homeViewNav;
    private View blogViewNav;
    private View repartNav;

    // 底部导航图标和文本
    private ImageView homeIcon, homeViewIcon, blogViewIcon, repartIcon;
    private TextView homeText, homeViewText, blogViewText, repartText;

    // 当前选中的导航项
    private View currentSelectedNav = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        setupClickListeners();

        // 默认选中 Home
        setSelectedNav(homeNav);
    }

    private void initializeViews() {
        // 初始化卡片视图
        fluidsCard = findViewById(R.id.fluidsCard);
        eventsCard = findViewById(R.id.eventsCard);
        openWayCard = findViewById(R.id.openWayCard);
        travelerCard = findViewById(R.id.travelerCard);
        hasesCard = findViewById(R.id.hasesCard);

        // 初始化底部导航
        homeNav = findViewById(R.id.homeNav);
        homeViewNav = findViewById(R.id.homeViewNav);
        blogViewNav = findViewById(R.id.blogViewNav);
        repartNav = findViewById(R.id.repartNav);

        // 初始化底部导航图标和文本
        homeIcon = findViewById(R.id.homeIcon);
        homeViewIcon = findViewById(R.id.homeViewIcon);
        blogViewIcon = findViewById(R.id.blogViewIcon);
        repartIcon = findViewById(R.id.repartIcon);

        homeText = findViewById(R.id.homeText);
        homeViewText = findViewById(R.id.homeViewText);
        blogViewText = findViewById(R.id.blogViewText);
        repartText = findViewById(R.id.repartText);
    }

    private void setupClickListeners() {
        // 卡片点击事件
        fluidsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Fluids 被点击");
                navigateToFluids();
                animateCardClick(v);
            }
        });

        eventsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Events 被点击");
                navigateToEvents();
                animateCardClick(v);
            }
        });

        openWayCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Open Way 被点击");
                navigateToOpenWay();
                animateCardClick(v);
            }
        });

        travelerCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Traveler 被点击");
                navigateToTraveler();
                animateCardClick(v);
            }
        });

        hasesCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("HASES 被点击");
                navigateToHases();
                animateCardClick(v);
            }
        });

        // 底部导航点击事件
        homeNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectedNav(homeNav);
                showToast("切换到 Home");
                navigateToHome();
            }
        });

        homeViewNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectedNav(homeViewNav);
                showToast("切换到 HomeView");
                navigateToHomeView();
            }
        });

        blogViewNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectedNav(blogViewNav);
                showToast("切换到 BlogView");
                navigateToBlogView();
            }
        });

        repartNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectedNav(repartNav);
                showToast("切换到 REPART");
                navigateToRepart();
            }
        });

        // 长按事件
        setupLongClickListeners();
    }

    private void setupLongClickListeners() {
        fluidsCard.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                showToast("长按 Fluids - 显示详细信息");
                return true;
            }
        });

        eventsCard.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                showToast("长按 Events - 显示详细信息");
                return true;
            }
        });

        openWayCard.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                showToast("长按 Open Way - 显示详细信息");
                return true;
            }
        });

        travelerCard.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                showToast("长按 Traveler - 显示详细信息");
                return true;
            }
        });

        hasesCard.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                showToast("长按 HASES - 显示详细信息");
                return true;
            }
        });
    }

    @SuppressLint("NonConstantResourceId")
    private void setSelectedNav(View selectedNav) {
        // 重置所有导航项
        resetAllNavItems();



        currentSelectedNav = selectedNav;
    }

    private void resetAllNavItems() {
        // 重置所有导航项颜色
        homeIcon.setColorFilter(Color.parseColor("#B0B0B0"));
        homeViewIcon.setColorFilter(Color.parseColor("#B0B0B0"));
        blogViewIcon.setColorFilter(Color.parseColor("#B0B0B0"));
        repartIcon.setColorFilter(Color.parseColor("#B0B0B0"));

        homeText.setTextColor(Color.parseColor("#B0B0B0"));
        homeViewText.setTextColor(Color.parseColor("#B0B0B0"));
        blogViewText.setTextColor(Color.parseColor("#B0B0B0"));
        repartText.setTextColor(Color.parseColor("#B0B0B0"));
    }

    // 导航方法
    private void navigateToFluids() {
        // 跳转到 Fluids 页面
        // Intent intent = new Intent(this, FluidsActivity.class);
        // startActivity(intent);
    }

    private void navigateToEvents() {
        // 跳转到 Events 页面
        // Intent intent = new Intent(this, EventsActivity.class);
        // startActivity(intent);
    }

    private void navigateToOpenWay() {
        // 跳转到 Open Way 页面
        // Intent intent = new Intent(this, OpenWayActivity.class);
        // startActivity(intent);
    }

    private void navigateToTraveler() {
        // 跳转到 Traveler 页面
        // Intent intent = new Intent(this, TravelerActivity.class);
        // startActivity(intent);
    }

    private void navigateToHases() {
        // 跳转到 HASES 页面
        // Intent intent = new Intent(this, HasesActivity.class);
        // startActivity(intent);
    }

    private void navigateToHome() {
        // 跳转到 Home 页面
        // 这里可以添加页面切换逻辑
    }

    private void navigateToHomeView() {
        // 跳转到 HomeView 页面
        // 这里可以添加页面切换逻辑
    }

    private void navigateToBlogView() {
        // 跳转到 BlogView 页面
        // 这里可以添加页面切换逻辑
    }

    private void navigateToRepart() {
        // 跳转到 REPART 页面
        // 这里可以添加页面切换逻辑
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void animateCardClick(View card) {
        card.animate()
                .scaleX(0.95f)
                .scaleY(0.95f)
                .setDuration(100)
                .withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        card.animate()
                                .scaleX(1f)
                                .scaleY(1f)
                                .setDuration(100)
                                .start();
                    }
                })
                .start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 清理资源
    }
}