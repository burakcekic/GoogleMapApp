const baseUrl = `/api/getData/getLocation?`;
$(document).ready(function(){
    $("#send").click(function(){
        let ltd = $("#latitude").val();
        let lng = $("#langitude").val();
        let radius = $("#radius").val();
        console.log("ltd:" + ltd);
        console.log("lng:" + lng);

        getHttpRequestAsync(generateUrl(lng,ltd,radius)).then(res =>{
            if(res.status == 200 && res.data.length > 0)
            {
                let data = res.data;
                let position = {lat:data[0].ltd,lng:data[0].lng}
                let map = generateMap(position);

                var infowindow = new google.maps.InfoWindow();
                var geocoder = new google.maps.Geocoder();

                data.forEach((e,i)=>{
                    marker = new google.maps.Marker({
                        position: {lat:e.ltd,lng:e.lng},
                        map: map
                    });

                    google.maps.event.addListener(marker, 'click', (function(marker, i) {
                        return function() {
                            geoCode({lat:e.ltd,lng:e.lng},geocoder,infowindow,map);

                        }
                    })(marker, i));
                });
            }
            else if(res.status == 200 && res.data.length == 0)  $("#info-modal").modal();
            else $("#error-modal").modal();

        });
    });
});

function geoCode(data,geocoder,infowindow,map)
{
    geocoder.geocode({ location: data }).then(res=>{
        let address = res.results[0].formatted_address;
        infowindow.setContent("<span>"+address+"</span>");
        infowindow.open(map, marker);
    });

}
function generateMap(position)
{
    let el = document.getElementById("map");
	map = new google.maps.Map(el,{center:position,zoom:6});
	return map
}

async function getHttpRequestAsync(link)
{
    var request = $.ajax({
        url:link,
        method: "GET",
        async:true,
        cache :false,
        timeout: 30000,
        success: function (data,textstatus,response)
        {

        },
        error: function (requset,status,error) {
            if(status=="timeout"){
                toast("warning","Zaman aşımı hatası lütfen tekrar deneyin","Uyarı");
            }
            else
            {
                console.log(requset);
                console.log(error);
            }
        }
    });

    return request;
}

function generateUrl(ltd,lng,radius)
{
    return baseUrl + `lng=${ltd}&ltd=${lng}&radius=${radius}`;
}