package com.divide2.er

/**
 * action_status
 * add_success
 * update_success
 * create by bvvy
 */
enum class ReturnCoder(val msg: String) {
    ADD_SUCCESS("MSG_ADD_SUCCESS"),
    DELETE_SUCCESS("MSG_DELETE_SUCCESS"),
    UPDATE_SUCCESS("MSG_UPDATE_SUCCESS"),
    ALREADY_EXISTS("MSG_ALREADY_EXISTS")
}
