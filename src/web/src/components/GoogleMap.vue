<template>
	<div class="container mt-3" id="app-main">
		<h2>Addres Ara</h2>
		<p>Enlem, Boylam ve Yarıçap bilgileri girilerek seçilen bölgedeki yerleri döndürür</p>
		<form class="mb-5 p-5 shadow border bg-light">
			<div class="row">
				<div class="col-4">
					<input type="number" id="latitude" v-model="latitude"  className="form-control">
				</div>
				<div class="col-4">
					<input type="number" id="longitude" v-model="longitude" className="form-control">
				</div>
				<div class="col-3">
					<input type="number" id="radius" v-model="radius" className="form-control">
				</div>
				<div class="col-1">
					<button id = "send" @click="initMap" type="button" className="btn btn-primary" >Gönder</button>
				</div>
			</div>
		</form>
		<!--<div id="map"></div>-->
		<GMapMap :center="center" :zoom="10"  style=" height: 600px"> 
      <GMapCluster :zoomOnClick="true">
        <GMapMarker
          :key="index"
          v-for="(m, index) in markers"
          :position="m"
          :clickable="true"
          :draggable="true"
          @click="center = m"
        />
      </GMapCluster>

		</GMapMap>
	</div>
</template>
<script>
import axios from "axios";


export default {
  name: 'mainComp',
  data(){
	return{
		center:null,
		markers:null,
		latitude:0,
		longitude:0,
		radius:0

	}
  },
  methods:{
	initMap(){ 
		const url = `http://localhost:8081/api/getData/getLocation?lng=${this.longitude}&ltd=${this.latitude}&radius=${this.radius}`;

		axios.get(url).then(res =>{

			if(res.data.status == 200 && res.data.data.length > 0)
			{
				let data = res.data.data;
				this.center = {lat:data[0].ltd,lng:data[0].lng};

				let arr = [];
				data.forEach((e) => {
					arr.push( {lat:e.ltd,lng:e.lng});
				});
				this.markers = arr; 
			}
			else if(res.data.status == 200 && res.data.data.length == 0)
			{
				alert("Seçmiş olduğunuz verilere ait bir veri gelmemektedir")
			}
			else 
			{
				alert("sistemde bir sorun oluştu lütfen daha sonra tekrar deneyiniz")
			}
		})
		.catch(err =>{
			console.log(err);
            alert("sistemde bir sorun oluştu lütfen daha sonra tekrar deneyiniz")
		});
		
	}
  }
}
</script>
<style scoped>
	#map {height: 600px; width: 100%;}
	html, body {height: 100%;margin: 0;padding: 0; }
</style>