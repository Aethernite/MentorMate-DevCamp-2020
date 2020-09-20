import React from 'react';
import styled from 'styled-components';

const CardBoxBase = styled.div`
border-bottom: 2px solid #f4f4f4;
`;

const List = styled.ul`
 margin: 10px 0px 10px 15px!important; 
 padding: 10px !important;
 font-size: 0px;	
  display: inline-block;
`;

const ListItem = styled.li`
list-style: none;
margin: 0px 0px 0px -8px !important;
padding: 0px 0px 0px 0px !important;
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
margin-right: 15px;
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

const Em = styled.em`
font-family: 'Roboto', sans-serif;
font-size: 12px;
font-weight: 500;
color: #8d8d8d;
position: relative;
top: 3px; `;

const Img = styled.img`
width: 25px;
height: 25px;
margin: 0px !important;
border: 2px solid #fff;
`;

function PostBase({ post }) {
    return (
        <CardBoxBase>
            <List>
                <ListItem><Anchor><Icon className="fa fa-thumbs-up"></Icon></Anchor></ListItem>
                {post.usersLiked.slice(0, 4).map((user, key) => (
                    <ListItem key={key}><Anchor href="#"><Img src={user.avatar} className="img-fluid rounded-circle" alt="User" /></Anchor></ListItem>
                ))}
                <ListItem><Anchor><Span>{post.likes} Likes</Span></Anchor></ListItem>
            </List>
            <List className="float-right">
                <ListItem><Anchor><Icon className="fa fa-comments"></Icon></Anchor></ListItem>
                <ListItem><Anchor><Em className="mr-5">{post.comments}</Em></Anchor></ListItem>
                <ListItem><Anchor><Icon className="fa fa-share-alt"></Icon></Anchor></ListItem>
                <ListItem><Anchor><Em className="mr-3">{post.shares}</Em></Anchor></ListItem>
            </List>
        </CardBoxBase>
    );
}

export default PostBase;
