/**
 * Created by Mars on 08.05.2017.
 */
function renderTable() {

    var course = $('#select-course').val();
    $.ajax({
        type: 'GET',
        url: '/coursesByCourse',
        data: {

            course: course,

        },
        success: function (data) {
            console.log(data);
            dataS=data;
            var $courses = $('.courses');
            $courses.find('.course-description').html("");
            $courses.find('tbody').html("");
            for (var i = 0; i < data.length; ++i) {
                var courseName = (data[i].courseName) ;
                var quota = "quota?";
                var teacher = (data[i].teacher.fullName) ;

                $courses.find('tbody').append(
                    '<tr id='+i+'>' +
                    '<td>' + courseName + '</td>' +
                    '<td>' + teacher + '</td>' +
                    '<td>' + quota + '</td>' +
                    '</tr>'
                );
            }
            $('table tbody tr').on('click', function (e) {
                $('table tr').removeClass('marked');
                $(this).addClass('marked');
                 renderDescrition( data[$(this).attr('id')].description)
            });

        }
    });
}

function renderDescrition(description) {
    var $courses = $('.courses');
    $courses.find('.course-description').html(description);
}




$(function () {
    $('.footable').footable();
    renderTable();

    $('#select-course').on('change', function () {
        renderTable()
    });





});