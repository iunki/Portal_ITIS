Date.prototype.getWeek = function () {
    var target = new Date(this.valueOf());
    var dayNr = (this.getDay() + 6) % 7;
    target.setDate(target.getDate() - dayNr + 3);
    var jan4 = new Date(target.getFullYear(), 0, 4);
    var dayDiff = (target - jan4) / 86400000;
    if (new Date(target.getFullYear(), 0, 1).getDay() < 5) {
        return 1 + Math.ceil(dayDiff / 7);
    }
    else {
        return Math.ceil(dayDiff / 7);
    }
};
function isEven(n) {
    return n % 2 == 0;
}

var monthNames = ["января", "февраля", "марта", "апреля", "мая", "июня",
    "июля", "августа", "сентября", "октября", "ноября", "декабря"
];
var dayNames = ["Воскресенье", "Понедельник", "Вторник", "Среда", "Четверг", "Пятница", "Суббота"];

function getDate() {
    return new Date($('#datepicker').datepicker('getDate'));
}
function getDateString() {
    var date = new Date($('#datepicker').datepicker('getDate'));
    date = ('0' + date.getDate()).slice(-2) + '.' + ('0' + (date.getMonth() + 1)).slice(-2) + '.' + date.getFullYear();
    console.log(date);
    return date;
}
function rerender() {
    var dateString = getDateString();
    var date = getDate();
    var group = $('#select-group').val();
    $.ajax({
        type: 'GET',
        url: '/timetablebygroup',
        data: {
            date: dateString, //getDate
            group: group,
            week: isEven(date.getWeek())
        },
        success: function (data) {
            console.log(data);
            var $schedule = $('.schedule');
            $schedule.find('.day-of-week').html(dayNames[date.getDay()]);
            $schedule.find('.day').html(date.getDate());
            $schedule.find('.month').html(monthNames[date.getMonth()]);
            $schedule.find('tbody').html("");
            for (var i = 0; i < 7; ++i) {
                var subjectName = (data[i].subjects[0].subjectName) ? data[i].subjects[0].subjectName : '-';
                var room = (data[i].subjects[0].room) ? data[i].subjects[0].room : '-';
                var teacher = (data[i].subjects[0].teacher) ? data[i].subjects[0].teacher : '-';
                $schedule.find('tbody').append(
                    '<tr>' +
                    '<td>' + data[i].startDate + '</td>' +
                    '<td>' + data[i].endDate + '</td>' +
                    '<td class="subject" data-teacher="' + teacher + '" data-type="0" data-subject="' + subjectName + '">' + subjectName + '</td>' +
                    '<td>' + room + '</td>' +
                    '</tr>'
                );
            }
        }
    });
}

$(function () {
    $('.select2').select2();

    $('#select-group').on('change', function () {
        rerender()
    });
    $(document).on('click', 'td.subject', function () {
        $td = $(this);
        if ($td.data('type') == 0) {
            $(this).html($(this).data('teacher'));
            $td.data('type', '1');
        } else {
            $(this).html($(this).data('subject'));
            $td.data('type', '0');
        }
    });
});

