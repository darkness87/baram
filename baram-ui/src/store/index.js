import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

const store = new Vuex.Store({
	state: {
		dailySalesChart: {
			data: {
				labels: ["M", "T", "W", "T", "F", "S", "S"],
				series: [[12, 17, 7, 17, 23, 18, 38]]
			}
		},
		dataCompletedTasksChart: {
			data: {
				labels: ["12am", "3pm", "6pm", "9pm", "12pm", "3am", "6am", "9am"],
				series: [[230, 750, 450, 300, 280, 240, 200, 190]]
			}
		},
		emailsSubscriptionChart: {
			data: {
				labels: ["Ja", "Fe", "Ma", "Ap", "Mai", "Ju", "Jul", "Au", "Se", "Oc", "No", "De"],
				series: [[542, 443, 320, 780, 553, 453, 326, 434, 568, 610, 756, 895]]
			}
		}
	},
	mutations: {
		increment(state) {
			state.count++;
		}
	},
	actions: {},
	modules: {}
});

export default store;
