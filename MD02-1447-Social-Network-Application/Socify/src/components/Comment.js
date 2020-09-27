import React from 'react';
import styled from 'styled-components';
import { placeholder, generateMediaUrl, formatDate } from '../utilities';
import { dislikeComment, likeComment } from '../store/slices/comments';
import { useDispatch } from 'react-redux';

const List = styled.ul`
 margin: 0px 0px 10px 15px!important; 
 padding: 10px !important;
 font-size: 0px;	
  display: inline-block;
`;

const ListItem = styled.li`
list-style: none;
display: inline-block;`;

const CardBoxComments = styled.div`
text-align: center;
display: inline-block;
width: 90%;
padding: 2%;
padding-left: 5%;
border-style: solid;
border-width: 1px;
border-color: #ededed;
border-left: none;
border-right: none;
border-top: none;
`;

const Img = styled.img`
width: 50px !important;
height: 50px !important;
margin: 0px;
vertical-align: top;
`;

const Text = styled.span`
font-style: 'Roboto', sans-serif;
font-size: 0.9rem;
font-weight: 300;
width: 22rem;
text-align: left;
vertical-align: top;
display: inline-block;
width: 90%;
`;

const Name = styled.span`
font-family: 'Roboto', sans-serif;
text-align: left;
font-size: 0.9rem;
display: block;
line-height: 1.5;
font-weight: 500;
`;

const Username = styled.span`
font-family: 'Roboto', sans-serif;
text-align: left;
font-size: 0.7rem;
display: block;
line-height: 1;
font-weight: 300;
`;

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

const CreatedAt = styled.div`
font-family: 'Roboto', sans-serif;
text-align: left;
font-size: 0.6rem;
display: block;
line-height: 2;
font-weight: 300;
font-style: italic;
`;

function Comment({ comment }) {
    const dispatch = useDispatch();
    return (
        <CardBoxComments className="w-100">
            <span className="float-left w-100" >
                <div class="media d-block d-md-flex mt-0" style={{ padding: '0px' }}>
                    <div class="media-body text-left">
                        <div style={{ backgroundColor: '#ededed', borderRadius: '0.4rem', padding: '0.5rem' }}>
                            <div style={{ display: 'block', paddingTop: '0px' }}>
                                <Img className="rounded-circle" src={comment.user.avatarId ? generateMediaUrl(comment.user.avatarId) : placeholder} alt="Avatar" />
                                <div style={{ display: 'inline-block' }}>
                                    <Name>{comment.user.name}</Name>
                                    <Username>({comment.user.username})</Username>
                                    <CreatedAt>{formatDate(comment.created_at)}</CreatedAt>
                                </div>
                            </div>
                            <div style={{ width: '100%', height: '100%', display: 'block' }}>
                                <Text className="ml-5">{comment.content}</Text>
                                {comment.mediaId &&
                                    <img className="img-fluid w-100 h-100" src={generateMediaUrl(comment.mediaId)} alt="Comment Media Content" />}
                            </div>
                        </div>
                        <List>
                            <ListItem onClick={() => dispatch(likeComment({ commentId: comment.id, postId: comment.postId }))}><Anchor><Icon className="fa fa-thumbs-up" style={{ color: `${comment.liked ? '#0e50ad' : '#8d8d8d'}` }}></Icon></Anchor></ListItem>
                            <ListItem><Span>{comment.likesCount} Likes</Span></ListItem>
                            <ListItem onClick={() => dispatch(dislikeComment({ commentId: comment.id, postId: comment.postId }))}><Anchor><Icon className="fa fa-thumbs-down ml-3" style={{ color: `${comment.disliked ? '#9e1616' : '#8d8d8d'}` }}></Icon></Anchor></ListItem>
                            <ListItem><Span>{comment.dislikesCount} Dislikes</Span></ListItem>
                        </List>
                        <div>
                        </div>
                    </div>
                </div>
            </span>
        </CardBoxComments>
    );
}

export default Comment;