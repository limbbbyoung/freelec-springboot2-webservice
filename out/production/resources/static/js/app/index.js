var main = { // scope(스코프)를 활용하는 이유는 중복된 함수 이름으로 인한 덮어쓰기를 피하기 위해
    // JS 파일마다 스코프를 만들어 사용합니다. 객체 안에서만 function이 유효하기 때문에 겹칠 위험이 사라짐
    init: function () {
        var _this = this;

        // 게시물 저장
        $('#btn-save').on('click', function () {
            _this.save();
        });

        // 게시물 수정
        $('#btn-update').on('click', function () {
            _this.update();
        });

    },
    save: function () {
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('글이 등록되었습니다.');
            window.location.href = '/'; // (1) window.location.href = '/'
                                        // 글 등록이 성공하면 메인페이지(/)로 이동합니다.
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    update: function () {
        var data = {
            title: $('#title').val(),
            content: $('#content').val()
        };

        var id = $('#id').val();

        $.ajax({
            type: 'PUT',
            url: '/api/v1/posts/' + id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('글이 수정되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
};

main.init();