package com.roger_hibernate.member.service;

import com.roger_hibernate.member.vo.MemberVO;

import java.util.List;
import java.util.Map;

public interface MemberService {

    /**
     * Adds a new member.
     *
     * @param memberVO The member object containing the details of the new member.
     * @return The added member object, possibly with an updated identifier.
     */
    MemberVO addMem(MemberVO memberVO);

    /**
     * Updates an existing member.
     *
     * @param memberVO The member object containing updated details of the member.
     * @return The updated member object.
     */
    MemberVO updateMem(MemberVO memberVO);

    /**
     * Deletes an existing member by their unique identifier.
     *
     * @param memNo The unique identifier of the member to be deleted.
     */
    void deleteMem(Integer memNo);

    /**
     * Retrieves a member by their unique identifier.
     *
     * @param memNo The unique identifier of the member.
     * @return The member object with the specified identifier, or null if not found.
     */
    MemberVO getOneMem(Integer memNo);

    /**
     * Retrieves a member by their name.
     *
     * @param mName The name of the member.
     * @return The member object with the specified name, or null if not found.
     */
    MemberVO getOneMemName(String mName);

    /**
     * Retrieves a member by their account.
     *
     * @param account The account of the member.
     * @return The member object with the specified account, or null if not found.
     */
    MemberVO getOneMemAccount(String account);

    /**
     * Retrieves a list of all members.
     *
     * @param currentPage The current page number for pagination.
     * @return A list of members on the specified page.
     */
    List<MemberVO> getAll(int currentPage);

    /**
     * Check if a member account exists.
     *
     * @param memAcc The account to check.
     * @return true if the account exists, false otherwise.
     */
    boolean isExistingMemberAccount(String memAcc);

    /**
     * Check if a member mobile number exists.
     *
     * @param memMob The mobile number to check.
     * @return true if the mobile number exists, false otherwise.
     */
    boolean isExistingMemberMobile(String memMob);

    /**
     * Check if a member email exists.
     *
     * @param memMail The email to check.
     * @return true if the email exists, false otherwise.
     */
    boolean isExistingMemberMail(String memMail);

    /**
     * Retrieves the total number of pages available.
     *
     * @return The total number of pages.
     */
    int getPageTotal();

    /**
     * Retrieves a list of members based on a composite query.
     *
     * @param map A map of query parameters where the key is a string representing the parameter name and the value is an array of strings representing the parameter values.
     * @return A list of members that match the criteria specified in the composite query.
     */
    List<MemberVO> getMembersByCompositeQuery(Map<String, String[]> map);
}
