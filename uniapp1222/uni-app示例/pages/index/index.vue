<template>
	<view class="content">
		<navigator url="/subpkg_task/detail/detail">点击这里跳转详情</navigator>
		<image class="logo" src="/static/logo.png"></image>
		<view class="text-area">
			<text class="title">{{ title }}</text>
		</view>
		<uni-countdown
			:day="1"
			:hour="1"
			:minute="12"
			:second="40"
		></uni-countdown>
		<uni-calendar
			:insert="true"
			:lunar="true"
			:start-date="'2019-3-2'"
			:end-date="'2019-5-20'"
			@change="change"
		/>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				title: 'Hello',
			}
		},
		onLoad() {},
		methods: {},
	}
</script>

<style lang="scss">
	page {
		background-color: $uni-bg-color;
	}

	.content {
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
	}

	.logo {
		height: 200rpx;
		width: 200rpx;
		margin-top: 200rpx;
		margin-left: auto;
		margin-right: auto;
		margin-bottom: 50rpx;
	}

	.text-area {
		display: flex;
		justify-content: center;
	}

	.title {
		font-size: 36rpx;
		color: #8f8f94;
	}
</style>
