<template>
	<form>
		<md-card>
			<md-card-header :data-background-color="dataBackgroundColor">
				<h4 class="title">유저 정보</h4>
				<p class="category">Complete your profile</p>
			</md-card-header>

			<md-card-content>
				<div class="md-layout">
					<div class="md-layout-item md-small-size-100 md-size-33">
						<md-field>
							<label>가입문파</label>
							<md-input v-model="company" disabled></md-input>
						</md-field>
					</div>
					<div class="md-layout-item md-small-size-100 md-size-33">
						<md-field>
							<label>유저명</label>
							<md-input v-model="username" type="text" disabled></md-input>
						</md-field>
					</div>
					<div class="md-layout-item md-small-size-100 md-size-33">
						<md-field>
							<label>승급차수</label>
							<md-input v-model="degree" type="email" disabled></md-input>
						</md-field>
					</div>
					<div class="md-layout-item md-small-size-100 md-size-25">
						<md-field>
							<label>레벨</label>
							<md-input v-model="level" type="number"></md-input>
						</md-field>
					</div>
					<div class="md-layout-item md-small-size-100 md-size-25">
						<md-field>
							<label>클래스</label>
							<md-input v-model="userClass" type="text"></md-input>
						</md-field>
					</div>
					<div class="md-layout-item md-small-size-100 md-size-50">
						<md-field>
							<label>직업</label>
							<md-input v-model="job" type="text"></md-input>
						</md-field>
					</div>
					<div class="md-layout-item md-small-size-100 md-size-100">
						<md-field>
							<label>한마디</label>
							<md-input v-model="say" type="text" disabled></md-input>
						</md-field>
					</div>
					<div class="md-layout-item md-size-100">
						<md-field maxlength="5">
							<label>남기고 싶은 말</label>
							<md-textarea v-model="aboutme"></md-textarea>
						</md-field>
					</div>
					<div class="md-layout-item md-size-100 text-right">
						<md-button class="md-raised md-success">Update Profile</md-button>
					</div>
				</div>
			</md-card-content>
		</md-card>
	</form>
</template>
<script>
export default {
	name: "edit-profile-form",
	props: {
		dataBackgroundColor: {
			type: String,
			default: ""
		}
	},
	data() {
		return {
			username: null,
			company: null,
			degree: null,
			level: null,
			userClass: null,
			job: null,
			aboutme: "Lamborghini Mercy, Your chick she so thirsty, I'm in that two seat Lambo."
		};
	}
};
</script>
<style></style>
