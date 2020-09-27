import React from 'react';
import styled from 'styled-components';
import { generateMediaUrl, placeholder } from '../../../utilities';
import PostHeaderDropdown from './PostHeaderDropdown';
import { Link } from 'react-router-dom';
import { useSelector } from 'react-redux';

const Header = styled.div`
padding: 16px;
margin: 0;
`;

const Text = styled.span`
padding: 0rem 2rem 2rem 0rem;
font-family: 'Roboto', sans-serif;
font-weight: 300;
font-size: 1.5rem;
`;

const Name = styled.span`
font-family: 'Roboto', sans-serif;
font-size: 1.2rem;
display: block;
font-weight: 500;
`;

const Username = styled.span`
font-family: 'Roboto', sans-serif;
font-size: 1rem;
display: block;
font-weight: 300;
`;
function PostHeader({ post }) {
    const user = useSelector(state => state.auth.user);
    return (
        <Header>
            <PostHeaderDropdown post={post} />
            <div className="media m-0">
                <div className="d-flex mr-3">
                    <Link to={`/${post.user.id === user.id ? 'me' : post.user.name}`} ><img className="img-fluid rounded-circle" style={{ objectFit: 'cover' }} src={post.user.avatarId ? generateMediaUrl(post.user.avatarId) : placeholder} alt="User" /></Link>
                </div>
                <div className="media-body">
                    <Name className="m-0">{post.user.name}</Name>
                    <Username className="m-0">({post.user.username})</Username>
                    <Text>{post.content}</Text>
                </div>
            </div>
        </Header>
    );
}

export default PostHeader;
