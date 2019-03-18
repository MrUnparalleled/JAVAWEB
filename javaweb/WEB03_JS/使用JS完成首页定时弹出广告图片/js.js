			function init2(){
			//				书写图片轮播的定时操作
				setInterval(change,1000);
			//				1.书写广告图片的定时操作
				s1=setInterval(AdShow,1000);
			}
			
			
			//实现图片轮播
			var i=1;
			function change(){
				i++;
				document.getElementById("changeImg").src="../img/"+i+".jpg"
				if (i==3) {
					i=1;
				}
			}
			//2.书写显示广告图片的函数
			function AdShow(){
				//3.获取广告图片的位置
				var adEle= document.getElementById("adImg");
				//4.修改图片的属性，让其显示
				adEle.style.display="block";
				//5.清除图片的定时操作
				clearInterval(s1);
				//6.设置隐藏图片的定时操作
				s1 = setInterval(hiddenAd,1000);
			}
			//7.书写隐藏广告图片的函数
			function hiddenAd(){
				//8.获取广告图片的位置，并修改图片的style中的display属性
				var adEle= document.getElementById("adImg");
				adEle.style.display="none";
				//9.清除图片的定时操作
				clearInterval(s1);
			}