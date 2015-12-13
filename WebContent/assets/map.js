d3.json('api/campuses', function (data) {
    var svg = d3.select('#map').append('svg')
            .attr('width', 960).attr('height', 332);

    svg.append('image')
        .attr('xlink:href', 'http://www.supinfo.com/SupinfoCommonResources/SUPINFO-PICTURES/News/ContentPicture/page-slash-campus-carte-plus-france-bleu.png')
        .attr('x', 0).attr('y', 0)
        .attr('width', 960).attr('height', 332);

    svg.selectAll('circle')
        .data(data).enter()
	        .append('circle')
	        	.attr('title', function(d) {
	        		return d.name;
	        	})
	            .attr('cx', function (d) {
	                return d.x + '%';
	            })
	            .attr('cy', function (d) {
	                return d.y + '%';
	            })
	            .attr('r', 4)
	            .attr('fill', 'rgb(247,12,0)');
});
