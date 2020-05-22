var provinces = {} || provinces
provinces.selectProvince = function () {
    $.ajax({
        url: 'http://localhost:8080/json/province',
        method: 'GET',
        datatype: 'JSON',
        success: function (data) {
            $('#province').empty();
            $('#province').append(
                `<option value="">--Chọn tỉnh thành--</option>`
            )
            $.each(data, function (i, province) {
                $('#province').append(
                    `<option value="${province.id_province}">${province.province}</option>`
                )
            })
        }
    })

    $("#province").change(function () {
            var provinceId = $('#province').val();
            $.ajax({
                url: 'http://localhost:8080/json/district/',
                method: 'GET',
                datatype: 'JSON',
                success: function (data) {
                    $('#district').empty();
                    $('#district').append(
                        `<option value="">--Chọn Quận / Huyện--</option>`
                    )
                    $.each(data, function (i, district) {
                        if (provinceId === district.province.id_province) {
                            $('#district').append(
                                `<option value="${district.id_district}">${district.district}</option>`
                            )
                        }
                    })
                }
            })
            $("#district").change(function () {
                    var districtId = $('#district').val();
                    $.ajax({
                            url: 'http://localhost:8080/json/ward',
                            method: 'GET',
                            datatype: 'JSON',
                            success: function (data) {
                                $('#ward').empty();
                                $('#ward').append(
                                    `<option value="">--Chọn Phường / Xã--</option>`
                                )
                                $.each(data, function (i, ward) {
                                    if (districtId === ward.district.id_district) {
                                        $('#ward').append(
                                            `<option value="${ward.id_ward}">${ward.ward}</option>`
                                        )
                                    }
                                })

                            }
                        }
                    )
                }
            )
        }
    )
}
