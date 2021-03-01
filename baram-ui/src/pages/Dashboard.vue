<template>
	<div class="content">
		<div class="md-layout">
			<div class="md-layout-item md-medium-size-50 md-xsmall-size-100 md-size-25">
				<stats-card data-background-color="green">
					<template slot="header">
						<md-icon>store</md-icon>
					</template>

					<template slot="content">
						<p class="category">문파 총원</p>
						<h3 class="title"><span>43</span>/45</h3>
					</template>

					<template slot="footer">
						<div class="stats">
							<md-icon class="text-danger">warning</md-icon>
							<a href="#pablo">문파원 공간확보필요</a>
						</div>
					</template>
				</stats-card>
			</div>
			<div class="md-layout-item md-medium-size-50 md-xsmall-size-100 md-size-25">
				<stats-card data-background-color="orange">
					<template slot="header">
						<md-icon>content_copy</md-icon>
					</template>

					<template slot="content">
						<p class="category">문파랭킹</p>
						<h3 class="title">
							103
							<small>위</small>
						</h3>
					</template>

					<template slot="footer">
						<div class="stats">
							<md-icon>date_range</md-icon>
							매일 집계
						</div>
					</template>
				</stats-card>
			</div>
			<div class="md-layout-item md-medium-size-50 md-xsmall-size-100 md-size-25">
				<stats-card data-background-color="red">
					<template slot="header">
						<md-icon>info_outline</md-icon>
					</template>

					<template slot="content">
						<p class="category">총 경험치</p>
						<h3 class="title">546,585</h3>
					</template>

					<template slot="footer">
						<div class="stats">
							<md-icon>local_offer</md-icon>
							레벨업 경험치 : 576,000
						</div>
					</template>
				</stats-card>
			</div>
			<div class="md-layout-item md-medium-size-50 md-xsmall-size-100 md-size-25">
				<stats-card data-background-color="blue">
					<template slot="header">
						<i class="fab fa-twitter"></i>
					</template>

					<template slot="content">
						<p class="category">금주 기여도</p>
						<h3 class="title">39,317</h3>
					</template>

					<template slot="footer">
						<div class="stats">
							<md-icon>update</md-icon>
							매일 0시 집계
						</div>
					</template>
				</stats-card>
			</div>
			<div class="md-layout-item md-medium-size-100 md-xsmall-size-100 md-size-33">
				<chart-card
					:chart-data="$store.state.dailySalesChart.data"
					:chart-options="dailySalesChart.options"
					:chart-type="'Line'"
					data-background-color="blue"
				>
					<template slot="content">
						<h4 class="title">총기여도</h4>
						<p class="category">
							<span class="text-success"><i class="fas fa-long-arrow-alt-up"></i> 3.78% </span>
							지난주 대비 상승하였습니다.
						</p>
					</template>

					<template slot="footer">
						<div class="stats">
							<md-icon>access_time</md-icon>
							자정 집계 기준
						</div>
					</template>
				</chart-card>
			</div>
			<div class="md-layout-item md-medium-size-100 md-xsmall-size-100 md-size-33">
				<chart-card
					:chart-data="$store.state.emailsSubscriptionChart.data"
					:chart-options="emailsSubscriptionChart.options"
					:chart-responsive-options="emailsSubscriptionChart.responsiveOptions"
					:chart-type="'Bar'"
					data-background-color="red"
				>
					<template slot="content">
						<h4 class="title">주간 기여도 순위</h4>
						<p class="category">
							한 주간 가장 많이 기여도를 한 10인
						</p>
					</template>

					<template slot="footer">
						<div class="stats">
							<md-icon>access_time</md-icon>
							자정 집계 기준
						</div>
					</template>
				</chart-card>
			</div>
			<div class="md-layout-item md-medium-size-100 md-xsmall-size-100 md-size-33">
				<chart-card
					:chart-data="$store.state.dataCompletedTasksChart.data"
					:chart-options="dataCompletedTasksChart.options"
					:chart-type="'Line'"
					data-background-color="green"
				>
					<template slot="content">
						<h4 class="title">레벨업 순위</h4>
						<p class="category">
							지난 주 대비 가장 많이 상승한 유저
						</p>
					</template>

					<template slot="footer">
						<div class="stats">
							<md-icon>access_time</md-icon>
							자정 집계 기준
						</div>
					</template>
				</chart-card>
			</div>
			<div class="md-layout-item md-medium-size-100 md-xsmall-size-100 md-size-50">
				<md-card>
					<md-card-header data-background-color="orange">
						<h4 class="title">레벨 순위</h4>
						<p class="category">2021-03-01 레벨업 순위 목록</p>
					</md-card-header>
					<md-card-content>
						<ordered-table table-header-color="orange"></ordered-table>
					</md-card-content>
				</md-card>
			</div>
			<div class="md-layout-item md-medium-size-100 md-xsmall-size-100 md-size-50">
				<nav-tabs-card>
					<template slot="content">
						<span class="md-nav-tabs-title">할일:</span>
						<md-tabs class="md-success" md-alignment="left">
							<md-tab id="tab-home" md-label="Bugs" md-icon="bug_report">
								<nav-tabs-table></nav-tabs-table>
							</md-tab>

							<md-tab id="tab-pages" md-label="Website" md-icon="code">
								<nav-tabs-table></nav-tabs-table>
							</md-tab>

							<md-tab id="tab-posts" md-label="server" md-icon="cloud">
								<nav-tabs-table></nav-tabs-table>
							</md-tab>
						</md-tabs>
					</template>
				</nav-tabs-card>
			</div>
		</div>
	</div>
</template>

<script>
import { StatsCard, ChartCard, NavTabsCard, NavTabsTable, OrderedTable } from "@/components";

export default {
	components: {
		StatsCard,
		ChartCard,
		NavTabsCard,
		NavTabsTable,
		OrderedTable
	},
	data() {
		return {
			dailySalesChart: {
				options: {
					lineSmooth: this.$Chartist.Interpolation.cardinal({
						tension: 0
					}),
					low: 0,
					high: 50, // creative tim: we recommend you to set the high sa the biggest value + something for a better look
					chartPadding: {
						top: 0,
						right: 0,
						bottom: 0,
						left: 0
					}
				}
			},
			dataCompletedTasksChart: {
				options: {
					lineSmooth: this.$Chartist.Interpolation.cardinal({
						tension: 0
					}),
					low: 0,
					high: 1000, // creative tim: we recommend you to set the high sa the biggest value + something for a better look
					chartPadding: {
						top: 0,
						right: 0,
						bottom: 0,
						left: 0
					}
				}
			},
			emailsSubscriptionChart: {
				data: {
					labels: ["Ja", "Fe", "Ma", "Ap", "Mai", "Ju", "Jul", "Au", "Se", "Oc", "No", "De"],
					series: [[542, 443, 320, 780, 553, 453, 326, 434, 568, 610, 756, 895]]
				},
				options: {
					axisX: {
						showGrid: false
					},
					low: 0,
					high: 1000,
					chartPadding: {
						top: 0,
						right: 5,
						bottom: 0,
						left: 0
					}
				},
				responsiveOptions: [
					[
						"screen and (max-width: 640px)",
						{
							seriesBarDistance: 5,
							axisX: {
								labelInterpolationFnc: function(value) {
									return value[0];
								}
							}
						}
					]
				]
			}
		};
	}
};
</script>
