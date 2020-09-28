import React from 'react';
import { useDispatch } from 'react-redux';
import styled from 'styled-components';
import { likePost, dislikePost } from '../../../store/slices/posts';
import { fetchCommentsForPost } from '../../../store/slices/comments';
import PostComments from './PostComments.js';

const CardBoxBase = styled.div`
`;

const List = styled.ul`
 margin: 10px 0px 10px 15px!important; 
 padding: 10px !important;
 font-size: 0px;	
  display: inline-block;
`;

const ListItem = styled.li`
list-style: none;
display: inline-block;`;

const Anchor = styled.a`
margin: 0px !important;
padding: 0px !important;
text-decoration: none;
&:hover{
background: #f4f4f4 !important;	
}
`;

const Icon = styled.i`
position: relative;
top: 4px; 
font-size: 12px;
color: #8d8d8d;
transform:scale(1.5);
transition: transform 0.2s;
&:hover{
transform:scale(1.8);
  cursor: pointer;
 }
`;

const Span = styled.span`
 font-family: 'Roboto', sans-serif;
 font-size: 12px;
 color: #8d8d8d;
 margin-left: 20px;
 position: relative;
 top: 5px; `;


const NumberBadge = styled.span`
    transform: scale(0.6) translateX(-0.7rem) translateY(-0.6rem);
    height: 15px;
    width: 15px;
    background-color: red;
    border-radius: 50%;
    display: inline-block;
`;


function PostBase({ post }) {
    const dispatch = useDispatch();
    const [commentsShown, setCommentsShown] = React.useState(false);

    const handleLike = () => {
        dispatch(likePost(post.id));
    }

    const handleDislike = () => {
        dispatch(dislikePost(post.id));
    }

    const handleComments = () => {
        dispatch(fetchCommentsForPost(post.id));
        if (commentsShown) {
            setCommentsShown(false);
        } else {
            setCommentsShown(true);
        }
    }

    return (
        <>
            <CardBoxBase>
                <List>
                    <ListItem onClick={() => handleLike()}><Anchor><Icon className="fa fa-thumbs-up" style={{ color: `${post.liked ? '#0e50ad' : '#8d8d8d'}` }}></Icon></Anchor></ListItem>
                    <ListItem><Anchor><Span>{post.likesCount} Likes</Span></Anchor></ListItem>
                    <ListItem onClick={() => handleDislike()}><Anchor><Icon className="fa fa-thumbs-down ml-3" style={{ color: `${post.disliked ? '#9e1616' : '#8d8d8d'}` }}></Icon></Anchor></ListItem>
                    <ListItem><Anchor><Span>{post.dislikesCount} Dislikes</Span></Anchor></ListItem>
                </List>
                <List className="float-right">
                    <ListItem><Anchor><Icon onClick={() => handleComments()} className="fa fa-comments"><NumberBadge className="badge badge-pill badge-danger">{post.commentsCount > 99 ? '99+' : post.commentsCount}</NumberBadge></Icon></Anchor></ListItem>
                    <ListItem><Anchor><Icon className="fa fa-share-alt ml-3"></Icon></Anchor></ListItem>
                </List>
            </CardBoxBase >
            <PostComments post={post} shown={commentsShown}></PostComments>
        </>
    );
}
//
// {post.usersLiked.slice(0, 4).map((user, key) => (
//    <ListItem key={key}><Anchor href="#"><Img src={user.avatar} className="img-fluid rounded-circle" alt="User" /></Anchor></ListItem>
//    ))}
//
export default PostBase;
