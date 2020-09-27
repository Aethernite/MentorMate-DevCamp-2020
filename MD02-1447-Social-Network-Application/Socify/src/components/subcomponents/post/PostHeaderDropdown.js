import React from 'react';
import { useDispatch, useSelector } from 'react-redux';
import styled from 'styled-components';
import { Link } from 'react-router-dom';
import { Dropdown } from 'react-bootstrap';
import { deletePost } from '../../../store/slices/posts';

const Button = styled.a`
    border-radius: 50%;
    font-size: 24px;
    height: 32px;
    width: 32px;
    padding: 0;
    overflow: hidden;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    text-align: center;
    transition: transform 0.2s;
    &:hover{
        transform: scale(1.2);
    }
    &::after{
        display: none;
    }
    `;


function PostHeaderDropdown({ post }) {

    const user = useSelector(state => state.auth.user);
    const dispatch = useDispatch();

    return (
        <Dropdown className="float-right">
            <Dropdown.Toggle as={Button}>
                <i className="fas fa-ellipsis-h" aria-hidden="true"></i>
            </Dropdown.Toggle>
            <Dropdown.Menu>
                <Dropdown.Item><Link to="/" style={{ padding: '0px' }}>Report</Link></Dropdown.Item>
                <Dropdown.Item style={{ display: `${post.user.id === user.id ? '' : 'none'}` }}><Link to="/" onClick={() => dispatch(deletePost(post.id))} style={{ padding: '0px' }}> Delete</Link></Dropdown.Item>
            </Dropdown.Menu>
        </Dropdown >
    );
}

export default PostHeaderDropdown;
