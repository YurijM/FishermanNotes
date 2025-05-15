package com.mu.fishermannotes.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Scale
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue

@Composable
fun ImagesSlider(
    modifier: Modifier = Modifier,
    imageList: MutableList<String>,
    initialPage: Int = 0,
    onClick: (String) -> Unit,
    backwardIcon: ImageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
    forwardIcon: ImageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
    dotsActiveColor: Color = Color.DarkGray,
    dotsInactiveColor: Color = Color.LightGray,
    dotSize: Dp = 8.dp,
    pagePaddingValues: PaddingValues = PaddingValues(horizontal = 64.dp),
    imageCornerRadius: Dp = 16.dp,
    imageHeight: Dp = 400.dp
) {
    val pagerState = rememberPagerState(
        initialPage = initialPage,
        pageCount = { imageList.size }
    )
    val scope = rememberCoroutineScope()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        /*Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.fillMaxWidth()
        ) {*/
            /*IconButton(
                enabled = pagerState.canScrollBackward,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage - 1)
                    }
                }
            ) {
                Icon(
                    imageVector = backwardIcon,
                    contentDescription = "back"
                )
            }*/
            HorizontalPager(
                state = pagerState,
                contentPadding = pagePaddingValues,
                //modifier = modifier.fillMaxSize()
                modifier = modifier.weight(1f)
            ) { page ->
                val pageOffset = (pagerState.currentPage - page) + pagerState.currentPageOffsetFraction
                val scaleFactor = 0.75f + (1f - 0.75f) * (1f - pageOffset.absoluteValue)
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = modifier
                        .graphicsLayer {
                            scaleX = scaleFactor
                            scaleY = scaleFactor
                        }
                        .alpha(scaleFactor.coerceIn(0f, 1f))
                        .padding(8.dp)
                        .clip(RoundedCornerShape(imageCornerRadius))
                ) {
                    AsyncImage(
                        model = ImageRequest
                            .Builder(LocalContext.current)
                            .scale(Scale.FILL)
                            .crossfade(true)
                            .data(imageList[page])
                            .build(),
                        contentDescription = "image",
                        contentScale = ContentScale.Crop,
                        //placeholder = painterResource(id = R.drawable.ic_image),
                        modifier = modifier
                            .height(imageHeight)
                            //.fillMaxHeight()
                            .alpha(if (pagerState.currentPage == page) 1f else 0.5f)
                            .clickable { onClick(imageList[page]) }
                    )
                }
            }
            /*IconButton(
                enabled = pagerState.currentPage != imageList.size - 1,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    }
                }
            ) {
                Icon(
                    imageVector = forwardIcon,
                    contentDescription = "forward"
                )
            }*/
        //}
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = modifier
                .height(48.dp)
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            repeat(imageList.size) {
                val color = if (pagerState.currentPage == it) dotsActiveColor else dotsInactiveColor
                Box(
                    modifier = modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .size(dotSize)
                        .background(color)
                        .clickable {
                            scope.launch {
                                pagerState.animateScrollToPage(it)
                            }
                        }
                )
            }
        }
    }
}