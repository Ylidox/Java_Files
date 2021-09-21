Array.prototype.max = function() {
  return Math.max.apply(null, this);
};

Array.prototype.min = function() {
  return Math.min.apply(null, this);
};

let showCity = {};
initShowCity();
function initShowCity(){
	for(let key in Citys){
		showCity[key] = 0;
	}
}

function createCanvas(w, h, arrayX, arrayY){

	const canvas = document.createElement('canvas');
	canvas.height = h;
	canvas.width = w;
	ctx = canvas.getContext('2d');

	let border = 30;

	w -= border; // оставляем место для обозначений на оси
	h -= border;

	ctx.transform(1, 0, 0, -1, 0, canvas.height);

	arrayY = arrayY.map((str) => {
		return +str;
	});

	let dy = Math.ceil(h / (arrayY.max() - arrayY.min() + 3));
	let dx = Math.ceil(w / arrayX.length);

	function drawAxes(){
		ctx.beginPath(); // ось y
			ctx.moveTo(border, border);
			ctx.lineTo(border, h + border);
			ctx.strokeStyle = 'black';
			ctx.stroke();
		ctx.closePath();
		ctx.beginPath(); // ось x
			ctx.moveTo(border, border);
			ctx.lineTo(w + border, border);
			ctx.strokeStyle = 'black';
			ctx.stroke();
		ctx.closePath();
		let min = '' + arrayY.min();
		for(let i = 0; i < arrayX.length; i++){
			addText(arrayX[i], border + i * dx, h + 6);
			addText( min++  + '', border - 8, h - i * dy);
		}
	}
	drawAxes();
	function addText(string, x, y){
		str = string[0] + (!isNaN(string[1]) ? string[1] : '');
		
		ctx.fillStyle = "#4CA028";
		ctx.font = "10px Verdana";
		ctx.textBaseline = "middle";
		ctx.textAlign = "center";

		ctx.transform(1, 0, 0, -1, 0, canvas.height);
		ctx.fillText(str, x, y);
		ctx.transform(1, 0, 0, -1, 0, canvas.height);
	}

	ctx.beginPath();
		ctx.moveTo(border, border);
		ctx.lineTo(border, arrayY[0] * dy);
		for(let i = 2; i < arrayY.length; i += 2){
			ctx.lineTo(i * dx + border, arrayY[i] * dy + border);
		}
		ctx.lineTo(w + border, border);
		ctx.strokeStyle = '#F9AA00';
		ctx.stroke();
		ctx.fillStyle = '#F9AA006a';
		ctx.fill();
	ctx.closePath();

	return canvas;
}

function addCanvas(div, i){
	if(showCity[i]) return;

	showCity[i] = 1;

	let canvas = createCanvas(600, 300, Citys[i][0] , Citys[i][1]);
	canvas.style.opacity = 0;

	let h = 100;

	let border = h + 300;
	let opacity = 0;

	let timer = setInterval(() => {
		if(h < border){
			h += 5;
			div.style.height = h + 'px';
		}else if(opacity == 0){
			opacity += 0.01;
			div.appendChild(canvas);
		}else if(opacity < 1){
			opacity += 0.02;
			canvas.style.opacity = opacity;
		}else{
			clearInterval(timer);
		}
	}, 16);
}

function removeCanvas(div, i){
	const canvas = div.querySelector('canvas');

	if(canvas.height < 300) return;

	showCity[i] = 0;

	let h = (div.style.height).split('');
	h.pop(); h.pop();
	h = +h.join('');
	
	canvas.style.opacity = 1;

	let timer = setInterval(() => {
		if(canvas.style.opacity > 0) canvas.style.opacity -= 0.1;
		if(h > 0){
			h -= 5;	

			div.style.height = h + 'px';
		} else{
			div.removeChild(canvas);
			clearInterval(timer);
		}
	}, 16);


}

window.onload = () => {
	const citys = document.getElementsByClassName("city");

	for(let i = 0; i < citys.length; i++){
		citys[i].onclick = (e) => {
			if(!showCity[i]) addCanvas(citys[i], i);
			else removeCanvas(citys[i], i);
		}
	}
}